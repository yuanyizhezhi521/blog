package xyz.xuexiblog.blog.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import xyz.xuexiblog.blog.pojp.ObjectName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OosUtil {
    public static void main(String [] array) throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4FcQPquFCfgfaVY8pEhk";
        String accessKeySecret = "Uja4ZnyT7BOxhDJJDfbrLGOFM2pVCn";
        String bucketName = "xuexiblog";

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// ossClient.listObjects返回ObjectListing实例，包含此次listObject请求的返回结果。
        ObjectListing objectListing = ossClient.listObjects(bucketName);
// objectListing.getObjectSummaries获取所有文件的描述信息。
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" - " + objectSummary.getKey() + "  " +
                    "(size = " + objectSummary.getSize() + ")");
        }
        List<ObjectName> objectNameList=new ArrayList<>();
        ObjectName objectName;
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" - " + objectSummary.getKey() + "  " +
                    "(size = " + objectSummary.getSize() + ")");
            objectName=new ObjectName();
            objectName.setObjectName(objectSummary.getKey());
            objectNameList.add(objectName);
        }

//
//// 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
//        OSSObject ossObject = null;
//        for (ObjectName o:objectNameList
//             ) {
//            ossObject = ossClient.getObject(bucketName, o.getObjectName());
//        }
//
//// 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
//        InputStream content = ossObject.getObjectContent();
//        if (content != null) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
//            while (true) {
//                String line = reader.readLine();
//                if (line == null) break;
//                System.out.println("\n" + line);
//            }
//            // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
//            content.close();
//        }

// 关闭OSSClient。
        ossClient.shutdown();
    }
}
