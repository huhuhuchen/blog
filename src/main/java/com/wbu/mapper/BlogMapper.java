package com.wbu.mapper;

import com.wbu.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //1、查询所有文章
    public List<Blog> getListByPage(Map<String, Integer> params);

    public int getCount();

    public int delete(int id);

    public int save(Blog blog);

    public int deleteAll(List ids);

    public Blog getById(int id);

    public List<Blog> list();
}
