package com.wbu.mapper;

import com.wbu.pojo.Category;

import java.util.List;
import java.util.Map;

public interface CategoryMapper {
    //根据id查询
    public Category getById(int id);

    public List<Category> getListByPage(Map<String, Integer> map);

    public int getCount();

    public int delete(int id);

    public int save(Category category);

    public int deleteAll(List ids);

    public List<Category> list();


}
