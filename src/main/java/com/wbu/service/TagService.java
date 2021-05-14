package com.wbu.service;

import com.wbu.pojo.Blog;
import com.wbu.pojo.Link;
import com.wbu.pojo.Tag;

import java.util.List;

/**
 * @Author huchen
 * @Date 2021/4/27 0027 下午 18:15
 */
public interface TagService {
    //查询所有用户
    public List<Tag> getListByPage(int page, int limit);

    public int getCount();

    public int delete(int id);

    public int save(Tag tag);

    public int deleteAll(String ids);

    public Tag getById(int id);

    public List<Tag> tagList();
    public  List<Tag> list();

}
