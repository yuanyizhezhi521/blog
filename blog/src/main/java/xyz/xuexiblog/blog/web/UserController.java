package xyz.xuexiblog.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import xyz.xuexiblog.blog.pojp.*;
import xyz.xuexiblog.blog.service.*;
import xyz.xuexiblog.blog.util.MD5Utils;
import xyz.xuexiblog.blog.util.PmsUploadUtil;
import xyz.xuexiblog.blog.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    TuserService tuserService;
    @Autowired
    TblogService tblogService;

    @Autowired
    TblogtagsService tblogtagsServiceImpl;
    @Autowired
    TtagService ttagServiceImpl;
    @Autowired
    TtypeService ttypeServiceImpl;
    @Autowired
    TcommentService tcommentService;


    /**
     * 登录
     * 为此用户是跳转到注册页面
     * @param tuser
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "login")
    public String login(Tuser tuser , HttpServletRequest request, HttpSession session){
        if (session.getAttribute("user")!=null){
            session.setMaxInactiveInterval(3600000);
            return "forward:/index";
        }else {
            tuser.setPassword(MD5Utils.code(tuser.getPassword()));
            Tuser tuser1 = tuserService.selectByNmaeAndPwd(tuser);
            if (tuser1!=null){
                session.setAttribute("user",tuser1);
                session.setMaxInactiveInterval(36000);
                return "forward:/index";
            }else {
                return "zhuce";
            }
        }

    }
    @RequestMapping(value = "user")
    public String user(){
        return "user/user";
    }

    /**
     * 首页
     *
     * @param tuser
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "index")
    public String index(Tuser tuser , HttpServletRequest request, HttpSession session){
        //blog的内容
        List<Tblog> tblogs = tblogService.selectAll();
        //推荐
        List<Tblogtags> tblogtags = tblogtagsServiceImpl.selectAll();
        //标签
        List<Ttag> ttags = ttagServiceImpl.selectAll();
        //分类selectByBlog
        List<Ttype> ttypes = ttypeServiceImpl.selectAll();
        int i = ttypeServiceImpl.selectByBlog();
        int i1 = ttagServiceImpl.selectByBlog();
        int selectcount = tblogService.selectcount();
        List<Tblog> selectRecommend =tblogService.selectRecommend();
        if(tblogs.size()>0){
            Page page=new Page();
            page.setTotalRecord(selectcount);
            page.setTotalPage(page.TotalPage(page.getTotalRecord(),page.getCurrentCount()));
            request.setAttribute("tblogs",tblogs);
            request.setAttribute("tblogtags",tblogtags);
            request.setAttribute("ttags",ttags);
            request.setAttribute("ttag",i1);
            request.setAttribute("ttypes",ttypes);
            request.setAttribute("ttype",i);
            request.setAttribute("recommendBlogs",selectRecommend);
            request.setAttribute("currentPage",page.getCurrentPage());
            request.setAttribute("totalPage",selectcount);
            return "index";
        }else {
            return "admin/index";
        }
    }

    /**
     * 注册
     * @param multipartFile
     * @param tuser
     * @return
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "registered")
    public String registered(@RequestParam("avatar_file") MultipartFile multipartFile,Tuser tuser) throws ClassNotFoundException {
        String s = PmsUploadUtil.uploadImage(multipartFile);
        tuser.setAvatar(s);
        tuser.setPassword(MD5Utils.code(tuser.getPassword()));
        int insert = tuserService.insertuser(tuser);
        if (insert>0){
            return "forward:/index";
        }else {
            return "zhuce";
        }

    }
    @RequestMapping(value = "about")
    public String about(){
        return "about";
    }

}
