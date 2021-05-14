package com.wbu.mapper;

import com.wbu.pojo.Comment;

import java.util.List;
import java.util.Map;

public interface CommentMapper {

    public Comment getById(int id);

    public int delete(int id);

    public int save(Comment comment);

    public List<Comment> getListByPage(Map<String ,Integer> params);

    public int getCount();

    public int deleteAll(List ids);

    public List<Comment> list();
}
