package com.wbu.service;

import com.wbu.mapper.LinkMapper;
import com.wbu.pojo.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LinkServiceImpl implements LinkService {

    private final LinkMapper linkMapper;

    public LinkServiceImpl(LinkMapper linkMapper) {
        this.linkMapper = linkMapper;
    }

    @Override
    public Link getById(int id) {
        return linkMapper.getById(id);
    }

    @Override
    public List<Link> getListByPage(int page, int limit) {
        Map<String,Integer> map=new HashMap<>();
        //分页的第一个参数   startNum表示从第几个开始查询   (page-1)*limit 表示查询的下标
        map.put("startNum",(page-1)*limit);
        //分页的第二个参数   limit 表示查询的个数
        map.put("pageSize",limit);
        return linkMapper.getListByPage(map);
    }

    @Override
    public int getCount() {
        return linkMapper.getCount();
    }

    @Override
    public int delete(int id) {
        return linkMapper.delete(id);
    }

    @Override
    public int save(Link link) {
        return linkMapper.save(link);
    }

    @Override
    public int deleteAll(String ids) {
        String[] array = ids.split(",");
        int count = linkMapper.deleteAll(Arrays.asList(array));
        return count;
    }

    @Override
    public List<Link> list() {
        return linkMapper.list();
    }
}
