package com.wbu.service;

import com.wbu.pojo.Comment;

import java.util.List;

public interface CommentService {

    public Comment getById(int id);

    public int delete(int id);

    public int save(Comment comment);

    public List<Comment> getListByPage(int page, int limit);

    public int getCount();

    public int deleteAll(String ids);

    public List<Comment> list();
}
