package com.brilworks.demo.service;

import java.util.List;

import com.brilworks.demo.DTO.UserDTO;
import com.brilworks.demo.exceptions.EntityNotFoundException;

public interface UserService {

    void save(UserDTO userDTO);

    UserDTO get(Integer id) throws EntityNotFoundException;

    List<UserDTO> getAll();

}

