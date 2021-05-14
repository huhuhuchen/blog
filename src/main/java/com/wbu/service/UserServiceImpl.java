package com.wbu.service;

import com.wbu.mapper.UserMapper;
import com.wbu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUser(String username,String password) {
        return userMapper.selectUser(username,password);
    }

    @Override
    public int getCount() {
        return userMapper.getCount();
    }
}
