package com.wbu.mapper;

import com.wbu.pojo.Banner;

import java.util.List;
import java.util.Map;

public interface BannerMapper {
    //1.根据id查询轮播图
    public Banner selectById(int id);

    //2.根据标题查询轮播图
    public Banner seleteByTitle(String title);

    //3.分页查询轮播图
    public List<Banner> getListByPage(Map<String,Integer> params);

    //4.查询轮播图的总记录数
    public int getCount();

    //5.
    public int updateSort(Map<String, Integer> map);

    //6.
    public int delete(int id);

    //7.
    public int save(Banner banner);


    public int deleteAll(List ids);

    public List<Banner> getList(Banner banner);
}
