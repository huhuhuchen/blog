package com.wbu.mapper;

import com.wbu.pojo.Link;

import java.util.List;
import java.util.Map;

public interface LinkMapper {
    public Link getById(int id);

    public List<Link> getListByPage(Map<String, Integer> map);

    public int getCount();

    public int delete(int id);

    public int save(Link link);

    public int deleteAll(List ids);

    public  List<Link> list();

}
