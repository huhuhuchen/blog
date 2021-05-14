package com.wbu.controller;

import com.wbu.pojo.ResponseResult;
import com.wbu.pojo.Tag;
import com.wbu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author huchen
 * @Date 2021/4/27 0027 下午 18:21
 */
@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/tag/list")
    public ResponseResult list(int page, int limit){
        ResponseResult result = new ResponseResult();
        List<Tag> list =  tagService.getListByPage(page, limit);
        result.setCode(0);
        result.setMessage("用户列表数据");
        result.setData(list);
        // 用户的总记录数
        result.setCount(tagService.getCount());
        return result;

    }

    //删除标签信息
    @RequestMapping("/tag/todelete")
    public ResponseResult delete(int id){
        //删除标签
        int count= tagService.delete(id);
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


    //添加标签
    @RequestMapping("/tag/tosave")
    public ResponseResult save(Tag tag ){
        ResponseResult result = new ResponseResult();
        int count = tagService.save(tag);
        if(count>0){
            //添加成功
            result.setCode(0);
            result.setMessage("标签添加成功");
        }else{
            result.setCode(-1);
            result.setMessage("标签添加失败");
        }
        return result;

    }

    @GetMapping("/tag/getById")  // 请求地址   url
    public Tag getById(Integer id){
        return tagService.getById(id);
    }

    @RequestMapping("/tag/deleteAll")
    public ResponseResult deleteAll(String ids ){
        ResponseResult result = new ResponseResult();
        //调用删除方法
        int count = tagService.deleteAll(ids);
        if(count>0){
            result.setCode(0);
            result.setMessage("批量删除成功");
        }else{
            result.setCode(-1);
            result.setMessage("批量删除失败");
        }
        return result;
    }

    @RequestMapping("/tag/taglist")
    public List<Tag> tagList(){
        return tagService.tagList();
    }

    @RequestMapping("/tag/count")
    public String getCount(){
       return String.valueOf(tagService.getCount()) ;
    }

}
