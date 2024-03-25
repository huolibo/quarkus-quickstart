package com.taosdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "user")
public class User {

  @Id
  private Long id;
  private String name;
  private String email;

  public User() {
  }

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }
}
