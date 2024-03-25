package com.taosdata.controller;

import com.taosdata.entity.User;
import com.taosdata.dao.UserMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/mybatis")
public class MybatisController {

  @Inject
  UserMapper userMapper;

  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
//  @Produces(MediaType.TEXT_PLAIN)
  public Iterable<User> findAll() {
    return userMapper.list();
  }

  @GET
  @Path("/user/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public User getUser(@PathParam("id") Integer id) {
    return userMapper.getUser(id);
  }

  @POST
  @Path("/user")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Integer createUser(@FormParam("id") Integer id, @FormParam("name") String name) {
    return userMapper.createUser(id, name);
  }

  @DELETE
  @Path("/user/{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public Integer removeUser(@PathParam("id") Integer id) {
    return userMapper.removeUser(id);
  }
}
