package com.javasb.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasb.practice.entities.Category;
import com.javasb.practice.repositories.CategoryRepository;


@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  public List<Category> findAll(){
    return repository.findAll();
  }
}
