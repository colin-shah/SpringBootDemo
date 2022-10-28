package com.brilworks.demo.controller;

import com.brilworks.demo.DTO.UserDTO;
import com.brilworks.demo.exceptions.EntityExistsException;
import com.brilworks.demo.exceptions.EntityNotFoundException;
import com.brilworks.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void save(@RequestBody UserDTO userDTO) throws EntityExistsException {
        userService.save(userDTO);
    }

    @GetMapping("user/{id}")
    public UserDTO get(@PathVariable Integer id) throws EntityNotFoundException {
        return userService.get(id);
    }

    @GetMapping("user")
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

}
