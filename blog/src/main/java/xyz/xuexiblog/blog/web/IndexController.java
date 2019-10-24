package xyz.xuexiblog.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.xuexiblog.blog.pojp.Tuser;

import javax.servlet.http.HttpSession;

@Controller

public class IndexController  {
    /**
     * 登录
     * @param session
     * @return
     */
    @RequestMapping("/login1")
    public String index(HttpSession session) {
        Tuser user = (Tuser) session.getAttribute("user");
        if (user == null) {
            return "login";
        }else {
            return "forward:/index";
        }
    }

}
