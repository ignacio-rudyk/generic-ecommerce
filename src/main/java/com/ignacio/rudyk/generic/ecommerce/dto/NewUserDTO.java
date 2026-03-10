package com.ignacio.rudyk.generic.ecommerce.dto;

import java.util.Date;

public record NewUserDTO(String email, String password, String firstName, String lastName, String indicative, String phone, Date bithday) { }