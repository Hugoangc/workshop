package com.javasb.practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.javasb.practice.entities.User;
import com.javasb.practice.repositories.UserRepository;
import com.javasb.practice.services.exceptions.DatabaseException;
import com.javasb.practice.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(Long id) {
    Optional<User> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public User insert(User obj) {
    return repository.save(obj);
  }

  public void delete(Long id) {
    try {
      repository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException(id);
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException(e.getMessage());
    }
  }

  public User update(Long id, User obj) {
    try {
      User entity = repository.getReferenceById(id);
      updateData(entity, obj);
      return repository.save(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(id);
    }
  }

  private void updateData(User entity, User obj) {
    if (obj.getName() != null) {
      entity.setName(obj.getName());
    }
    if (obj.getEmail() != null) {
      entity.setEmail(obj.getEmail());
    }
    if (obj.getPhone() != null) {
      entity.setPhone(obj.getPhone());
    }

  }

  public void changePassword(Long userId, String newPassword) {
    User user = repository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException(userId));
    String hashedPassword = passwordEncoder.encode(newPassword);
    user.setPassword(hashedPassword);

    repository.save(user);
  }
}
