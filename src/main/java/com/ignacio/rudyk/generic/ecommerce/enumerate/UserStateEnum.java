package com.ignacio.rudyk.generic.ecommerce.enumerate;

public enum UserStateEnum {

    ACTIVO("001"),
    INACTIVO("002"),
    SUSPENDIDO("003");

    private String code;

    UserStateEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}