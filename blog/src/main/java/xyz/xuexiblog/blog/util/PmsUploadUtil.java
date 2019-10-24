package xyz.xuexiblog.blog.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PmsUploadUtil {
    public static String uploadImage(MultipartFile multipartFile){

        // 配置fdfs的全局链接地址
        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();// 获得配置文件的路径
        String[] uploadInfos=null;
        try {
            ClientGlobal.init(tracker);
            TrackerClient trackerClient = new TrackerClient();

            // 获得一个trackerServer的实例
            TrackerServer trackerServer = trackerClient.getConnection();

            // 通过tracker获得一个Storage链接客户端
            StorageClient storageClient = new StorageClient(trackerServer, null);
            //获取上传的二进制文件
            byte[] bytes = multipartFile.getBytes();
            System.out.println(bytes.length);

            //获取上传文件的名字
            String originalFilename = multipartFile.getOriginalFilename();
            System.out.println(originalFilename);
            int i = originalFilename.lastIndexOf(".");
            //截取字符串
            String extName = originalFilename.substring(i+1);
            uploadInfos = storageClient.upload_file(bytes, extName, null);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }


        String url = "http://47.102.110.105";

        for (String uploadInfo : uploadInfos) {
            url += "/" + uploadInfo;

            //url = url + uploadInfo;
        }
System.out.println(url);


        return url;
    }


}
