package com.javasb.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javasb.practice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
