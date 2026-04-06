package com.ignacio.rudyk.generic.ecommerce.enumerate;

public enum OrderStateEnum {

    CONFIRMADO("001"),
    EN_PROCESO("002"),
    CANCELADO("003"),
    REEMBOLSADO("004");

    private String code;

    OrderStateEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }


}
