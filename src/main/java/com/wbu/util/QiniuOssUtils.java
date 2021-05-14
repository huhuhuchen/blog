package com.wbu.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * 不积小流无以成江海 不积跬步无以至千里
 * 多学一点知识 少写一行代码
 *
 * @Author 秃头宝贝 2021/3/24 22:50
 */
@Component
public class QiniuOssUtils {

    Auth auth=null;

    BucketManager bucketManager=null;


    private Gson gson=new Gson();

    private String bucket="mrchai-imgs";

    private String accessKey="6ufeDvo4w59tnkoQh5bwDJKAj9txnW1RWmrku99L";

    private String secretKey="94HgtmySulPOcXzsCL6mMNGVPkZEdWks4mHyQmqK";

    /**
     * 上传文件
     * @param is
     * @param fileName
     * @return  返回url地址
     */
    public String uploadFile(InputStream is,String fileName){
        try {
            //首先获取新的文件名
            fileName = getNewFileName(fileName);
            auth  = Auth.create(accessKey,secretKey);
            String upToken = auth.uploadToken(bucket);  //上传凭证
            Configuration cfg = new Configuration(Zone.autoZone());
            UploadManager uploadManager = new UploadManager(cfg);

            //上传并获取响应
            Response resp = uploadManager.put(is, fileName, getUploadToken(), null, null);
            // 解析上传成功的结果
            DefaultPutRet defaultPutRet = gson.fromJson(resp.bodyString(), DefaultPutRet.class);
            if(resp.statusCode == 200){
                //返回文件存储在服务器的地址
                return new StringBuffer().append("http://imgs.cmusic.softeem.top/").append(fileName).toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    /**
     * 删除资源
     * @param key
     * @return
     */
    public void deleteFile(String key){

        auth  = Auth.create(accessKey,secretKey);
        String upToken = auth.uploadToken(bucket);  //上传凭证
        Configuration cfg = new Configuration(Zone.autoZone());

        bucketManager = new BucketManager(auth, cfg);

        try {
            if( fileStatus(key) != null){
                Response resp = bucketManager.delete(bucket, key);
            }
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询文件状态
     * @param key
     * @return
     */
    public FileInfo fileStatus(String key){
        try {
            FileInfo info = bucketManager.stat(bucket, key);
            return info;
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 根据url获取文件名
     * @param url
     * @return
     */
    public String getKey(String url){
        int i = url.lastIndexOf("/");
        return url.substring(i + 1);
    }

    private String getUploadToken(){
        return auth.uploadToken(bucket);
    }

    public static void main(String[] args) {
        //为了保证上传的图片是唯一的，需要将文件名修改
        String str = "abc.jpg";  //abc4342323877.jpg
        long d = System.currentTimeMillis();
        String newFileName = str.substring(0,str.lastIndexOf("."));
        newFileName += d;
        newFileName += str.substring(str.lastIndexOf("."));
        System.out.println(newFileName);
    }

    /**
     * 根据文件名返回一个新的文件名（不重复的）
     * @param str 文件名
     * @return
     */
    public static String getNewFileName(String str){
        //获取系统时间毫秒数
        long d = System.currentTimeMillis();
        // 不包含后缀的文件名
        String newFileName = str.substring(0,str.lastIndexOf("."));
        // 追加时间字符串
        newFileName += d;
        // 追加 后缀
        newFileName += str.substring(str.lastIndexOf("."));
        return newFileName;
    }

}
