package com.javasb.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javasb.practice.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
