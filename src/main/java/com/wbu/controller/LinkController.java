package com.wbu.controller;

import com.wbu.pojo.Category;
import com.wbu.pojo.Link;
import com.wbu.pojo.ResponseResult;
import com.wbu.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @RequestMapping("/link/list")   //url请求地址
    public ResponseResult list(int page, int limit){
        ResponseResult result=new ResponseResult();
        List<Link> list = linkService.getListByPage(page, limit) ;
        result.setCode(0);
        result.setMessage("链接列表数据");
        result.setData(list);
        //用户的总记录数
        result.setCount(linkService.getCount());
        return result;
    }

    @RequestMapping("/link/delete")
    //删除用户信息
    public ResponseResult delete(int id){
        //删除用户
        int count=  linkService.delete(id);
        ResponseResult result = new ResponseResult();
        if(count>0) {
            result.setCode(0);
            result.setMessage("链接删除成功");
        }else {
            result.setCode(-1);
            result.setMessage("链接删除失败");
        }
        return  result;
    }

    @RequestMapping("/link/save")
    //添加分类信息
    public ResponseResult save(Link link){
        System.out.println("category----------"+link);
        ResponseResult result = new ResponseResult();
        int count = linkService.save(link);
        if (count>0){
            //添加成功
            result.setCode(0);
        }else {
            result.setCode(-1);
            result.setMessage("链接添加失败");
        }
        return result;
    }

    @RequestMapping("/link/deleteAll")
    public ResponseResult deleteAll(String ids){
        ResponseResult result=new ResponseResult();

        int count = linkService.deleteAll(ids);
        if(count>0){
            result.setCode(0);
            result.setMessage("链接删除成功");
        }else{
            result.setCode(-1);
            result.setMessage("链接删除失败");
        }
        return result;
    }

    //获取链接列表
    @RequestMapping("/link/linkList")
    public List<Link> linkList(){
        return linkService.list();
    }

    //返回首页记录数
    @RequestMapping("/link/count")
    public int count(){
        return linkService.getCount();
    }


}
