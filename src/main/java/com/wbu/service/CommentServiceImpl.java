package com.wbu.service;

import com.wbu.mapper.CommentMapper;
import com.wbu.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Comment getById(int id) {
        return commentMapper.getById(id);
    }

    @Override
    public int delete(int id) {
        return commentMapper.delete(id);
    }

    @Override
    public int save(Comment comment) {
        return commentMapper.save(comment);
    }

    @Override
    public List<Comment> getListByPage(int page, int limit) {
        Map<String,Integer> map = new HashMap<>();
        // 分页的第一个参数
        map.put("startNum",(page-1)*limit);
        // 分页的第二个擦书
        map.put("pageSize",limit);

        return  commentMapper.getListByPage(map);
    }

    @Override
    public int getCount() {
        return commentMapper.getCount();
    }

    @Override
    public int deleteAll(String ids) {
        // 根据id 查询每一个头像地址如果地址不为空 则先删除头像地址 1,2,3
        String [] array = ids.split(",");
        int count = commentMapper.deleteAll( Arrays.asList(array));

        return count;
        }

    @Override
    public List<Comment> list() {
        return commentMapper.list();
    }
}
