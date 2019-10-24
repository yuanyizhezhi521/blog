package xyz.xuexiblog.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.xuexiblog.blog.pojp.Tblog;
import xyz.xuexiblog.blog.pojp.Ttag;
import xyz.xuexiblog.blog.pojp.Ttype;
import xyz.xuexiblog.blog.service.TblogService;
import xyz.xuexiblog.blog.service.TblogtagsService;
import xyz.xuexiblog.blog.service.TtagService;
import xyz.xuexiblog.blog.service.TtypeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
    @Autowired
    TblogService tblogService;
    @Autowired
    TblogtagsService tblogtagsService;
    @Autowired
    TtagService ttagService;
    @Autowired
    TtypeService ttypeService;

    /**
     * 管理页面
     * @param request
     * @return
     */
    @RequestMapping(value = "blogs")
    public String blog(HttpServletRequest request){
        List<Tblog> blogs = tblogService.selectAll();
        request.setAttribute("blog",blogs);
        return "admin/blogs";
    }

    /**
     * admin/logout
     * @param request
     * @return
     */
    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request, HttpSession session){
        session.removeAttribute("user");
        return "forward:/login1";
    }

    /**
     * 分类管理页面
     * @param request
     * @return
     */
    @RequestMapping(value = "types")
    public String types(HttpServletRequest request){
        List<Ttype> ttypes = ttypeService.selectAll();
        request.setAttribute("type",ttypes);
        return "admin/types";
    }

    /**
     * 标签管理页面
     * @param request
     * @return
     */
    @RequestMapping(value = "tags")
    public String tags(HttpServletRequest request){
        List<Ttag> ttags = ttagService.selectAll();
        request.setAttribute("tags",ttags);
        return "admin/tags";
    }


}
