package com.taosdata.dao;

import com.taosdata.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

  @Query("select u from user u")
  List<User> list();
}
