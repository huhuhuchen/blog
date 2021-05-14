package com.wbu.service;

import com.wbu.pojo.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BannerService {
    //1.根据id查询轮播图
    public Banner selectById(int id);

    //2.根据标题查询轮播图
    public Banner seleteByTitle(String title);

    //3.分页查询轮播图
    public List<Banner> getListByPage(int page,int limit);

    //4.查询轮播图的总记录数
    public int getCount();

    //5.根据id修改轮播图
    public int updateSort(int id,int sort);

    //6.根据id删除轮播图
    public int delete(int id);

    //7.
    public int save(Banner banner);

    public int deleteAll(String ids);

    public List<Banner> getList(Banner banner);
}
