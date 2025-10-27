package com.javasb.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasb.practice.entities.Order;
import com.javasb.practice.repositories.OrderRepository;


@Service
public class OrderService {

  @Autowired
  private OrderRepository repository;

  public List<Order> findAll(){
    return repository.findAll();
  }
}
