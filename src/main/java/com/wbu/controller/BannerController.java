package com.wbu.controller;

import com.wbu.pojo.Banner;
import com.wbu.pojo.ResponseResult;
import com.wbu.service.BannerService;
import com.wbu.util.QiniuOssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class BannerController {
    @Autowired
    private BannerService bannerService;


    @GetMapping("/banner/selectById")
    public Banner selectById(int id){
        return bannerService.selectById(id);
    }


    @GetMapping("/banner/seleteByTitle")
    public Banner seleteByTitle(String title){
        return bannerService.seleteByTitle(title);
    }

    @RequestMapping("/banner/list")
    public ResponseResult list(int page,int limit){
        ResponseResult result = new ResponseResult();
        List<Banner> list = bannerService.getListByPage(page,limit);
        result.setCode(0);
        result.setMessage("轮播图表数据");
        result.setData(list);
        //用户的总记录数
        result.setCount(bannerService.getCount());
        return result;
    }

    @RequestMapping("/banner/updateSort")
    public ResponseResult updateSort(int id, int sort){
        int count = 0;
        if(sort == 0){
            count = bannerService.updateSort(id,1);
        }else if(sort == 1){
            count = bannerService.updateSort(id,0);
        }
        ResponseResult result = new ResponseResult();
        if(count>0) {
            result.setCode(0);
            result.setMessage("修改成功");
        }else {
            result.setCode(-1);
            result.setMessage("修改失败");
        }
        return  result;
    }


    @RequestMapping("/banner/delete")
    public ResponseResult delete(int id){
        //删除轮播图
        int count = bannerService.delete(id);
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

    //添加用户信息（包含头像上传功能）
    @RequestMapping("/banner/save")
    public ResponseResult save(Banner banner,
                                MultipartFile file){
        System.out.println("banner-------"+banner);
        ResponseResult result = new ResponseResult();
        //1.将文件上传到服务器商，并返回服务器地址  （七牛云服务器）
        try {
            if (file != null) {
                QiniuOssUtils qiniuOssUtils = new QiniuOssUtils();
                String url = qiniuOssUtils.uploadFile(file.getInputStream(), file.getOriginalFilename());
                System.out.println("url-----"+url);
                //将头像地址放入Path中
                banner.setPath(url);
                //2.根据文件上传的结果 返回的路径，存放到header属性中,并添加用户对象
                int count = bannerService.save(banner);

                if(count > 0){
                    //添加成功
                    result.setCode(0);
                }else{
                    result.setCode(-1);
                    result.setMessage("文件上传失败");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(-1);
            result.setMessage("轮播图添加失败，文件上传失败");
        }
        return result;
    }

    @RequestMapping("/banner/deleteAll")
    public ResponseResult deleteAll(String ids){
        ResponseResult result = new ResponseResult();
        //调用删除的方法
        int count = bannerService.deleteAll(ids);
        if(count > 0){
            result.setCode(0);
            result.setMessage("删除成功");
        }else{
            result.setCode(-1);
            result.setMessage("删除失败");
        }
        return result;
    }

    @RequestMapping("/banner/getList")
    public ResponseResult getList(Banner banner){
        ResponseResult result = new ResponseResult();
        List<Banner> list = bannerService.getList(banner);
        result.setCode(0);
        result.setMessage("轮播图表数据");
        result.setData(list);
        //用户的总记录数
        result.setCount(bannerService.getCount());
        return result;
    }

}
