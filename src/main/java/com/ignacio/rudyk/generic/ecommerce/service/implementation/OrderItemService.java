package com.ignacio.rudyk.generic.ecommerce.service.implementation;

import com.ignacio.rudyk.generic.ecommerce.dto.CartProdutcDTO;
import com.ignacio.rudyk.generic.ecommerce.exception.BadRequestException;
import com.ignacio.rudyk.generic.ecommerce.repository.IOrderItemRepository;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.OrderItem;
import com.ignacio.rudyk.generic.ecommerce.service.IOrderItemService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService implements IOrderItemService {

    private IOrderItemRepository orderItemRepository;

    public OrderItemService(IOrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<OrderItem> saveItems(Long orderId, List<CartProdutcDTO> products) {
        List<OrderItem> items = new ArrayList<>();
        if(products.isEmpty())
            throw new BadRequestException("La lista de productos esta vacia");
        for(CartProdutcDTO cartProdutc : products) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(cartProdutc.product().id());
            orderItem.setOrderId(orderId);
            orderItem.setProductTitle(cartProdutc.product().title());
            orderItem.setUnitPrice(cartProdutc.product().price().price());
            orderItem.setSubTotal(calculateSubtotalItem(cartProdutc.product().price().price(), cartProdutc.quantity()));
            orderItem.setQuantity(cartProdutc.quantity());
            items.add(orderItem);
        }
        orderItemRepository.saveAll(items);
        return items;
    }

    private BigDecimal calculateSubtotalItem(BigDecimal price, Long quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

}
