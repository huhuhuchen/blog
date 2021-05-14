package com.wbu.service;

import com.wbu.mapper.TagMapper;
import com.wbu.pojo.Blog;
import com.wbu.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author huchen
 * @Date 2021/4/27 0027 下午 18:16
 */
@Service
public class TagServiceImpl implements TagService {
    private final TagMapper tagMapper;

    public TagServiceImpl(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public List<Tag> getListByPage(int page, int limit) {
        Map<String,Integer> map = new HashMap<>();
        map.put("startNum",(page-1)*limit);
        map.put("pageSize",limit);
        return tagMapper.getListByPage(map);
    }

    @Override
    public int getCount() {
        return tagMapper.getCount();
    }

    @Override
    public int delete(int id) {
        return tagMapper.delete(id);
    }

    @Override
    public int save(Tag tag) {
        return tagMapper.save(tag);
    }

    @Override
    public int deleteAll(String ids) {
        // 根据id 查询每一个头像地址如果地址不为空 则先删除头像地址 1,2,3
        String [] array = ids.split(",");
        int count = tagMapper.deleteAll( Arrays.asList(array));
        return count;
    }

    @Override
    public Tag getById(int id) {
        return tagMapper.getById(id);
    }

    @Override
    public List<Tag> tagList() {
        return tagMapper.tagList();
    }

    @Override
    public List<Tag> list() {
        return tagMapper.list();
    }
}
