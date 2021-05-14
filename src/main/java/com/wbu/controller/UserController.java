package com.wbu.controller;

import com.wbu.pojo.User;
import com.wbu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String login(String username,String password){
        User user = userService.selectUser(username,password);
        if (user!=null&&user.getPassword().equals(password)){
                return "main";
        }else {
            return "login";
        }

    }

    @ResponseBody
    @RequestMapping("/user/count")
    public String getCount(){
        return String.valueOf(userService.getCount());
    }

}
