package com.wbu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private String phone;
    private String email;
    private String hicon;
    private String summmary;
    private String wxcode;
    private Date lastlogin;
    private Date nowlogin;
    private String lastip;
    private String nowip;
}
