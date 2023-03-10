package com.revature.swagshop.exceptions;

public class UserAlreadyRegisteredException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public UserAlreadyRegisteredException() {
    super("User already has an account");
  }

}
