package com.wbu.service;

import com.wbu.mapper.BannerMapper;
import com.wbu.pojo.Banner;
import com.wbu.pojo.ResponseResult;
import com.wbu.util.QiniuOssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private QiniuOssUtils qiniuOssUtils;

    @Override
    public Banner selectById(int id) {
        return bannerMapper.selectById(id);
    }

    @Override
    public Banner seleteByTitle(String title) {
        return bannerMapper.seleteByTitle(title);
    }

    @Override
    public List<Banner> getListByPage(int page, int limit) {
        Map<String,Integer> map = new HashMap<>();
        //分页的第一个参数
        map.put("startNum",(page-1)*limit);
        //分页的第二个参数
        map.put("pageSize",limit);

        return bannerMapper.getListByPage(map);
    }

    @Override
    public int getCount() {
        return bannerMapper.getCount();
    }

    @Override
    public int updateSort(int id,int sort) {
        //根据id改状态
        Map<String,Integer> map = new HashMap<>();
        map.put("id",id);
        map.put("sort",sort);
        return bannerMapper.updateSort(map);
    }

    @Override
    public int delete(int id) {
        return bannerMapper.delete(id);
    }

    @Override
    public int save(Banner banner) {
        return bannerMapper.save(banner);
    }

    @Override
    public int deleteAll(String ids) {
        //根据id查询每一个头像地址如果地址不为空，则先删除头像地址
        String [] array = ids.split(",");
        for(String id : array){
            //根据id查询每一条记录
            Banner banner = bannerMapper.selectById(new Integer(id));
////            判断是否有头像 如果存在头像地址 则删除
//            if(!StringUtils.isEmpty(banner.getPath())){
//                qiniuOssUtils.deleteFile(banner.getPath());
//            }
        }
        //然后再删除记录数
        //数组转集合
        int count = bannerMapper.deleteAll(Arrays.asList(array));
        return count;
    }

    @Override
    public List<Banner> getList(Banner banner) {
        return bannerMapper.getList(banner);
    }
}
