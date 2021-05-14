package com.wbu.service;

import com.wbu.pojo.Category;

import java.util.List;

public interface CategoryService {
    //根据id查询
    public Category getById(int id);

    public List<Category> getListByPage(int page, int limit);

    public int getCount();

    public int delete(int id);

    public int save(Category category);

    public int deleteAll(String ids);

    public List<Category> list();
}
