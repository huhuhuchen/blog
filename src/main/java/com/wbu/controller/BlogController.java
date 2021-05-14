package com.wbu.controller;

import com.wbu.pojo.Blog;
import com.wbu.pojo.ResponseResult;
import com.wbu.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @ResponseBody
    @RequestMapping("/list")
    public ResponseResult list(int page, int limit){
        ResponseResult result = new ResponseResult();
        List<Blog> list =  blogService.getListByPage(page, limit);
        result.setCode(0);
        result.setMessage("用户列表数据");
        result.setData(list);
        result.setCount(blogService.getCount());
        return result;

    }

    //删除博客信息
    @ResponseBody
    @RequestMapping("/todelete")
    public ResponseResult delete(int id){
        //删除博客
        int count=  blogService.delete(id);
        ResponseResult result = new ResponseResult();
        if(count>0) {
            result.setCode(0);
            result.setMessage("删除成功");
        }else {
            result.setCode(-1);
            result.setMessage("删除失败");
        }
        return  result;
    }


    //添加博客
    @ResponseBody
    @RequestMapping("/tosave")
    public ResponseResult save(Blog blog ){
        ResponseResult result = new ResponseResult();
                int count = blogService.save(blog);
                if(count>0){
                    //添加成功
                    result.setCode(0);
                }else{
                    result.setCode(-1);
                    result.setMessage("博客添加失败");
                }
        return result;

    }

    @ResponseBody
    @GetMapping("/getById")  // 请求地址   url
    public Blog getById(Integer id){
        return blogService.getById(id);
    }

    @ResponseBody
    @RequestMapping("/deleteAll")
    public ResponseResult deleteAll(String ids ){
        ResponseResult result = new ResponseResult();
        //调用删除方法
        int count = blogService.deleteAll(ids);
        if(count>0){
            result.setCode(0);
            result.setMessage("删除成功");
        }else{
            result.setCode(-1);
            result.setMessage("删除失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/blog/listBlog")
    public List<Blog> listBlog(){
        return blogService.list();
    }

    @ResponseBody
    @RequestMapping("/blog/count")
    public String getCount(){
        return String.valueOf(blogService.getCount());
    }
}
