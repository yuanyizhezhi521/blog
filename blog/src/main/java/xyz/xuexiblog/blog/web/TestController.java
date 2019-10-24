package xyz.xuexiblog.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    /**
     *
     * 测试使用
     * @return
     */
    @RequestMapping("test")
    public String test(){
        return "test/test";
    }
}
