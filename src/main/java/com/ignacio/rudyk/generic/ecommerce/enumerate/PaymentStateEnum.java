package com.ignacio.rudyk.generic.ecommerce.enumerate;

public enum PaymentStateEnum {

    PENDIENTE("001"),
    APROBADO("002"),
    RECHAZADO("003"),
    REEMBOLSADO("004"),
    CANCELADO("005");

    private String code;

    PaymentStateEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
