package com.wbu.service;

import com.wbu.pojo.User;

public interface UserService {
    public User selectUser(String username,String password);

    public int getCount();
}
