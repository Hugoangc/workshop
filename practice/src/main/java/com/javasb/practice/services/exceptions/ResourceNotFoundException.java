package com.javasb.practice.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(Object id){
    super("Resource not found. Id " + id);
  }
}
