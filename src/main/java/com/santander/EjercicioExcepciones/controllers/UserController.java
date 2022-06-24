package com.santander.EjercicioExcepciones.controllers;


import com.santander.EjercicioExcepciones.dtos.RequestUserDTO;
import com.santander.EjercicioExcepciones.dtos.ResponseDTO;
import com.santander.EjercicioExcepciones.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO createUser(@RequestBody RequestUserDTO requestUserDTO) {

        return new ResponseDTO(userService.createUser(requestUserDTO.getEmail(), requestUserDTO.getPassword()));
    }
}
