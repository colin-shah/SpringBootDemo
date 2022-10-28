package com.brilworks.demo.service.impl;

import com.brilworks.demo.DTO.UserDTO;
import com.brilworks.demo.entity.User;
import com.brilworks.demo.exceptions.EntityNotFoundException;
import com.brilworks.demo.repositories.UserRepositories;
import com.brilworks.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositories userRepositories;

    @Override
    @Transactional
    public void save(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        userRepositories.save(user);
    }

    @Override
    @Transactional
    public UserDTO get(Integer id) throws EntityNotFoundException {
        Optional<User> userOptional = userRepositories.findById(id);
        UserDTO userDTO = null;
        if (userOptional.isPresent()) {
            userDTO = new UserDTO();
            BeanUtils.copyProperties(userOptional.get(), userDTO);
        } else {
            throw new EntityNotFoundException("Entity not found for given Id");
        }

        return userDTO;
    }

    @Override
    @Transactional
    public List<UserDTO> getAll() {
        List<User> userList = userRepositories.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        if (userList != null && !userList.isEmpty()) {
            for (User user : userList) {
                UserDTO userDTO = new UserDTO();
                BeanUtils.copyProperties(user, userDTO);
                userDTOList.add(userDTO);
            }
        }
        return userDTOList;
    }

}

