package com.taosdata.dao;

import com.taosdata.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

  @Select("SELECT * FROM user")
  List<User> list();

  @Select("SELECT * FROM user WHERE id = #{id}")
  User getUser(Integer id);

  @Insert("INSERT INTO user (id, name) VALUES (#{id}, #{name})")
  Integer createUser(@Param("id") Integer id, @Param("name") String name);

  @Delete("DELETE FROM user WHERE id = #{id}")
  Integer removeUser(Integer id);
}
