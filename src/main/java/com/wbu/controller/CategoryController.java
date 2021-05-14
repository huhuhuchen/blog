package com.wbu.controller;

import com.wbu.pojo.Category;
import com.wbu.pojo.ResponseResult;
import com.wbu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category/list")   //url请求地址
    public ResponseResult list(int page, int limit){
        ResponseResult result=new ResponseResult();
        List<Category> list = categoryService.getListByPage(page, limit) ;
        result.setCode(0);
        result.setMessage("用户列表数据");
        result.setData(list);
        //用户的总记录数
        result.setCount(categoryService.getCount());
        return result;
    }

    @RequestMapping("/category/delete")
    //删除用户信息
    public ResponseResult delete(int id){
        //删除用户
        int count=  categoryService.delete(id);
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

    @RequestMapping("/catagory/save")
    //添加分类信息
    public ResponseResult save(Category category){
        System.out.println("category----------"+category);
        ResponseResult result = new ResponseResult();
                int count = categoryService.save(category);
                if (count>0){
                    //添加成功
                    result.setCode(0);
                }else {
                    result.setCode(-1);
                    result.setMessage("用户添加失败");
                }
        return result;
    }

    @RequestMapping("/category/deleteAll")
    public ResponseResult deleteAll(String ids){
        ResponseResult result=new ResponseResult();

        int count = categoryService.deleteAll(ids);
        if(count>0){
            result.setCode(0);
            result.setMessage("删除成功");
        }else{
            result.setCode(-1);
            result.setMessage("删除失败");
        }
        return result;
    }


    @RequestMapping("/category/cname")
    public List<Category> listCategory(){
        return categoryService.list();
    }

    @RequestMapping("/category/count")
    public String getCount(){
        return String.valueOf(categoryService.getCount());
    }
}
