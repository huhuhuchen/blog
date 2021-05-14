package com.wbu.mapper;

import com.wbu.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User selectUser(@Param("username") String username,@Param("password")String password);

    public int getCount();
}
