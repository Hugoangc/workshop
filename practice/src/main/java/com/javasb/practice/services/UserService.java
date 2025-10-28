package com.javasb.practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

import com.javasb.practice.entities.User;
import com.javasb.practice.repositories.UserRepository;


import jakarta.persistence.EntityNotFoundException;


@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> findAll(){
    return repository.findAll();
  }

  public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
    return obj.get();
  }
  public User insert(User obj){
    return repository.save(obj);
  }
}
