package com.javasb.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasb.practice.entities.Product;
import com.javasb.practice.repositories.ProductRepository;


@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public List<Product> findAll(){
    return repository.findAll();
  }
}
