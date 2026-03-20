package com.ignacio.rudyk.generic.ecommerce.controller;

import com.ignacio.rudyk.generic.ecommerce.dto.NewUserDTO;
import com.ignacio.rudyk.generic.ecommerce.dto.response.ResponseDTO;
import com.ignacio.rudyk.generic.ecommerce.service.IUserService;
import com.ignacio.rudyk.generic.ecommerce.util.HttpUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<ResponseDTO> createUser(HttpServletRequest httpServletRequest, @RequestBody NewUserDTO newUser) {
        LOGGER.info("Llamado al servicio /create-user - body: {}", newUser);
        userService.createUser(newUser);
        return HttpUtil.isSucceful2xxResponse(httpServletRequest, null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getUser(HttpServletRequest httpServletRequest, @PathVariable Long id) {
        LOGGER.info("Llamado al servicio /get-user - ID: {}", id);
        return HttpUtil.isSucceful2xxResponse(httpServletRequest, userService.findById(id));
    }

    @PutMapping("/update-user")
    public ResponseEntity<ResponseDTO> updateUser(HttpServletRequest httpServletRequest, @RequestBody NewUserDTO newUser) {
        LOGGER.info("Llamado al servicio /update-user - body: {}", newUser);
        userService.updateUser(newUser);
        return HttpUtil.isSucceful2xxResponse(httpServletRequest, null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(HttpServletRequest httpServletRequest, @PathVariable Long id) {
        LOGGER.info("Llamado al servicio /delete-user - ID: {}", id);
        userService.deleteUser(id);
        return HttpUtil.isSucceful2xxResponse(httpServletRequest, null);
    }

}