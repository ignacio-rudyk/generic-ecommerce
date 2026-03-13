package com.ignacio.rudyk.generic.ecommerce.dto;

import java.util.Date;

public record UserDTO(Long id, Long roleId, String firstName, String lastName, UserContactDTO userContactDTO, Long avatarFileId, Date createdAt, UserStateDTO userStateDTO, Date birthday) { }
