package com.taosdata.controller;

import com.taosdata.dao.UserRepository;
import com.taosdata.entity.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/jpa")
public class JPAController {

  private final UserRepository userRepository;

  public JPAController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  public Iterable<User> findAll() {
    return userRepository.list();
  }

  @GET
  @Path("/user/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public User getUser(@PathParam("id") Long id) {
    return userRepository.findById(id).orElse(null);
  }

  @POST
  @Path("/user")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Integer createUser(@FormParam("email") String email, @FormParam("name") String name) {
    User save = userRepository.save(new User(email, name));
    return save.getId().intValue();
  }

  @DELETE
  @Path("/user/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public void removeUser(@PathParam("id") Long id) {
    userRepository.deleteById(id);
  }
}
