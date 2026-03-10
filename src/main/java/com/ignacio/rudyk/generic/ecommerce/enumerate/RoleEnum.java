package com.ignacio.rudyk.generic.ecommerce.enumerate;

public enum RoleEnum {

    ADMIN("001"),
    USER("002");

    private String code;

    RoleEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
