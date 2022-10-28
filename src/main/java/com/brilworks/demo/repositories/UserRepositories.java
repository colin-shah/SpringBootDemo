package com.brilworks.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.brilworks.demo.entity.User;

import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer>{

    Optional<User> findByName(String name);
}