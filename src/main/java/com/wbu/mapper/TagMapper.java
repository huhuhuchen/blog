package com.wbu.mapper;

import com.wbu.pojo.Blog;
import com.wbu.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author huchen
 * @Date 2021/4/27 0027 下午 18:11
 */
public interface TagMapper {

    public List<Tag> getListByPage(Map<String ,Integer> params);
    public int getCount();

    public int delete(int id);

    public int save(Tag tag);

    public int deleteAll(List ids);

    public Tag getById(int id);

    public List<Tag> tagList();

    public  List<Tag> list();
}
