package xyz.xuexiblog.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xyz.xuexiblog.blog.util.PmsUploadUtil;

import java.io.IOException;
@Controller
public class ImgController {
    @RequestMapping(value = "img")
    public String fileUpload() throws IOException {
        return "img/img";
    }

    /**
     * 图片上传到服务器
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String imgUrl= PmsUploadUtil.uploadImage(multipartFile);
        return imgUrl;
    }
}
