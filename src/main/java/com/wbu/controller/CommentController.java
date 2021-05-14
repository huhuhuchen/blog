package com.wbu.controller;

import com.wbu.pojo.Comment;
import com.wbu.pojo.ResponseResult;
import com.wbu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("/users/getById")  // 请求地址   url
    public Comment getById(Integer id){
        return commentService.getById(id);
    }


    @RequestMapping("/comment/list")   // 请求查询地址
    public ResponseResult list(int page, int limit){
        ResponseResult result = new ResponseResult();
        List<Comment> list =  commentService.getListByPage(page, limit);
        result.setCode(0);
        result.setMessage("用户列表数据");
        result.setData(list);
        // 用户的总记录数
        result.setCount(commentService.getCount());
        return result;

    }

    //删除用户信息
    @RequestMapping("/comment/delete")
    public ResponseResult delete(int id){
        //删除用户
        int count=  commentService.delete(id);
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


//    //添加用户信息 （包含头像上次功能）
//    @RequestMapping("/comment/save")
//    public ResponseResult save(Comment comment ,
//                               @RequestParam("file") MultipartFile file){
//        ResponseResult result = new ResponseResult();
//        //1、 将文件上次到 服务器商，并返回要给服务器地址   （七牛云服务器）
//        try {
//            if (file != null) {
//
////                String url = qiniuOssUtils.uploadFile(file.getInputStream(),
////                        file.getOriginalFilename()); //上传文件名
////                System.out.println("url-----"+url);
////                //将头像地址放入  header中
////                users.setHeader(url);
//                //2、 根据文件上传的结果 返回的路径 ，存放到 header属性中，并添加用户对象
//                int count = commentService.save(comment);
//                if(count>0){
//                    //添加成功
//                    result.setCode(0);
//                }else{
//                    result.setCode(-1);
//                    result.setMessage("用户添加失败");
//                }
//            }
//        }catch (Exception ee){
//            ee.printStackTrace();
//            result.setCode(-1);
//            result.setMessage("用户添加失败，文件上传失败");
//        }
//        return result;
//
//    }
        //添加分类信息
          @RequestMapping("/comment/save")
            public ResponseResult save(Comment comment){
             System.out.println("comment----------"+comment);
             ResponseResult result = new ResponseResult();
             int count = commentService.save(comment);
                if (count>0){
                    //添加成功
                    result.setCode(0);
             }else {
                    result.setCode(-1);
               result.setMessage("用户添加失败");
           }
          return result;
                }


    @RequestMapping("comment/deleteAll")
    public ResponseResult deleteAll(String ids ){
        ResponseResult result = new ResponseResult();
        //调用删除方法
        int count = commentService.deleteAll(ids);
        if(count>0){
            result.setCode(0);
            result.setMessage("删除成功");
        }else{
            result.setCode(-1);
            result.setMessage("删除失败");
        }
        return result;
    }

    @RequestMapping("/com/count")
    public String getCount(){
        return String.valueOf(commentService.getCount());
    }

    @RequestMapping("comment/comm")
    public List<Comment> listComment(){
        return commentService.list();
    }

}
