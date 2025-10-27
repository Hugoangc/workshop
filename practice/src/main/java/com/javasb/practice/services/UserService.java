package com.javasb.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasb.practice.entities.User;
import com.javasb.practice.repositories.UserRepository;


@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> findAll(){
    return repository.findAll();
  }
}
