package com.wbu.service;

import com.alibaba.druid.util.StringUtils;
import com.wbu.mapper.CategoryMapper;
import com.wbu.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category getById(int id) {
        return categoryMapper.getById(id);
    }

    @Override
    public List<Category> getListByPage(int page, int limit) {
        Map<String,Integer> map=new HashMap<>();
        //分页的第一个参数   startNum表示从第几个开始查询   (page-1)*limit 表示查询的下标
        map.put("startNum",(page-1)*limit);
        //分页的第二个参数   limit 表示查询的个数
        map.put("pageSize",limit);
        return categoryMapper.getListByPage(map);
    }

    @Override
    public int getCount() {
        return categoryMapper.getCount();
    }

    @Override
    public int delete(int id) {
        return categoryMapper.delete(id);
    }

    @Override
    public int save(Category category) {
        return categoryMapper.save(category);
    }

    @Override
    public int deleteAll(String ids) {
        //根据id查询每个头像地址  如果地址不为空 则先删除头像地址
        String[] array = ids.split(",");
        for (String id : array) {
            //根据每个id查询每条记录
            Category user = categoryMapper.getById(new Integer(id));

            // 然后再删除记录数
        }
            int count = categoryMapper.deleteAll(Arrays.asList(array));

            return count;
        }

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }


}
