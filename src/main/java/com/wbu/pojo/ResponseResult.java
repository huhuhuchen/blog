package com.wbu.pojo;

import lombok.Data;

/**
 * ClassName: ResponseResult
 * Description:
 * date: 2021/4/22 15:42
 *
 * @author wuyafeng
 * @version 1.0   softeem.com
 */
@Data
public class ResponseResult {
    private int code;  //  为了与前端结果一致  0： 表示成功
    private String message;
    private Object data;// 表示后端响应给前端的结果数据
    private int count; //数据的总数  、//  生成getter  setter方法
}
