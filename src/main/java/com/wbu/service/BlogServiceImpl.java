package com.wbu.service;

import com.wbu.mapper.BlogMapper;
import com.wbu.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;


    @Override
    public List<Blog> getListByPage(int page, int limit) {
        Map<String,Integer> map = new HashMap<>();
        map.put("startNum",(page-1)*limit);
        map.put("pageSize",limit);
        return blogMapper.getListByPage(map);
    }

    @Override
    public int getCount() {
        return blogMapper.getCount();
    }

    @Override
    public int delete(int id) {
        return blogMapper.delete(id);
    }

    @Override
    public int save(Blog blog) {
        return blogMapper.save(blog);
    }

    @Override
    public int deleteAll(String ids) {
        // 根据id 查询每一个头像地址如果地址不为空 则先删除头像地址 1,2,3
        String [] array = ids.split(",");
        for(String id : array){
            //根据id查询每一条记录
            blogMapper.getById(new Integer(id));
            //判断是否有头像  如果存在头像地址 则删除
        }
        //然后在删除记录数
        // 数组转成集合
        int count = blogMapper.deleteAll( Arrays.asList(array));

        return count;
    }

    @Override
    public Blog getById(int id) {
        return blogMapper.getById(id);
    }

    @Override
    public List<Blog> list() {
        return blogMapper.list();
    }
}
