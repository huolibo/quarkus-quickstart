package com.taosdata.controller;

import com.taosdata.dao.UserRepository;
import com.taosdata.entity.User;
import jakarta.ws.rs.FormParam;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping("/list")
  public List<User> list() {
    return userRepository.list();
  }

  @GetMapping("/{id}")
  public User getUser(@PathVariable("id") Long id) {
    return userRepository.findById(id).orElse(null);
  }

  @PostMapping("/add")
  public Integer createUser(@FormParam("email") String email, @FormParam("name") String name) {
    User save = userRepository.save(new User(email, name));
    return save.getId().intValue();
  }

  @DeleteMapping("/delete/{id}")
  public void removeUser(@PathVariable("id") Long id) {
    userRepository.deleteById(id);
  }
}
