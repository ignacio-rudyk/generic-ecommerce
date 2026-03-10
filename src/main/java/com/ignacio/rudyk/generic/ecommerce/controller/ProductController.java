package com.ignacio.rudyk.generic.ecommerce.controller;

import com.ignacio.rudyk.generic.ecommerce.dto.ProductRequestDTO;
import com.ignacio.rudyk.generic.ecommerce.dto.response.ResponseDTO;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping
    public ResponseEntity<ResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequest, HttpRequest httpRequest) {
        return ResponseEntity.ok(new ResponseDTO());
    }

}