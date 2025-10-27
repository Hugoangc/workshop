package com.javasb.practice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasb.practice.entities.Order;
import com.javasb.practice.services.OrderService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/orders")

public class OrderResource {

  @Autowired
  private OrderService service;

  @GetMapping
  public ResponseEntity<List<Order>> findAll(){
    List<Order> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }
}
