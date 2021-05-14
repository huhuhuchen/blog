package com.wbu.service;

import com.wbu.pojo.Link;

import java.util.List;

public interface LinkService {
    //根据id查询
    public Link getById(int id);

    public List<Link> getListByPage(int page, int limit);

    public int getCount();

    public int delete(int id);

    public int save(Link link);

    public int deleteAll(String ids);

    public  List<Link> list();
}
