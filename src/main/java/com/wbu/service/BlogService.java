package com.wbu.service;

import com.wbu.pojo.Blog;

import java.util.List;

public interface BlogService {
    //查询所有用户
    public List<Blog> getListByPage(int page, int limit);

    public int getCount();

    public int delete(int id);

    public int save(Blog blog);

    public int deleteAll(String ids);

    public Blog getById(int id);

    public List<Blog> list();
}
