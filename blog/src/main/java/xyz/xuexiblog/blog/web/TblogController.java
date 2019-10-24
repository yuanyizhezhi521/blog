package xyz.xuexiblog.blog.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.xuexiblog.blog.pojp.*;
import xyz.xuexiblog.blog.service.*;
import xyz.xuexiblog.blog.util.MarkdownUtils;
import xyz.xuexiblog.blog.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * blogcontroller
 */
@Controller
public class TblogController {
    @Autowired
    TblogService tblogService;
    @Autowired
    TblogtagsService tblogtagsService;
    @Autowired
    TtagService ttagService;
    @Autowired
    TtypeService ttypeService;
    @Autowired
    TcommentService tcommentService;


    /**
     * //查询全部文章
     * @param request
     * @return
     */
    @RequestMapping(value = "BlogAll")
    public String selectBlogAll(HttpServletRequest request){
        List<Tblog> tblogs = tblogService.selectAll();
        request.setAttribute("blog",tblogs);
        return "admin/blogs";
    }

    /**
     * /添加文章
     * @param tblog
     * @param name
     * @param type
     * @param tagIds
     * @param session
     * @return
     */

    @RequestMapping(value = "insert")
    public String insert(Tblog tblog,String[] name,Ttype type,String [] tagIds,HttpSession session){
        tblog.setCreateTime(new Date());
        tblog.setTypeId(type.getId());
        Tuser user = (Tuser) session.getAttribute("user");
        tblog.setUserId(user.getId());
        tblog.setShareStatement(true);
        tblog.setViews(0);
        tblog.setTypeId(tblog.getTtype().getId());
        Tblogtags tblogtags = null;
        List<Tblogtags> list=new ArrayList<>();
        int insert = tblogService.insert(tblog);
        Tblog tblog1 = tblogService.selectByName(tblog.getDescription());
        for (int i = 0; i <tagIds.length ; i++) {
            tblogtags=new Tblogtags();
            tblogtags.setBlogsId(tblog1.getId());
            tblogtags.setTagsId( Long.parseLong(tagIds[i]));
            list.add(tblogtags);
        }
        int insert1 = tblogtagsService.insertlist(list);
        if (insert>0){
            return "forward:/admin/blogs";
        }
        return "forward:/input";
    }

    /**
     *
     * @param session
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "input")
    public String input(HttpSession session,HttpServletRequest request ,Model model){
        Tuser user = (Tuser) session.getAttribute("user");
        List<Ttype> ttypes = ttypeService.selectAll();
        List<Ttag> ttags = ttagService.selectAll();
        request.setAttribute("types",ttypes);
        request.setAttribute("tags",ttags);
        return "admin/blogs-input";
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model,HttpServletRequest request){
        getBlog(id,model,request,tblogService,ttagService,tcommentService);
        return "blog";
    }
    @PostMapping("/blog/update")
    public String blogupdate(Tblog tblog, Model model){

        System.out.println("12345666");
        int i = tblogService.updateByPrimaryKeySelective(tblog);
        return "forward:/index";
    }

    @GetMapping("/blogs/{id}/input")
    public String updaBlog(@PathVariable Long id, Model model,HttpServletRequest request){
        Tblog tblog = tblogService.selectByPrimaryKey(id);
        model.addAttribute("blog",tblog);
        List<Ttype> ttypes = ttypeService.selectAll();
        pub(request,tblogService);
        model.addAttribute("type",ttypes);
        List<Ttag> ttags = ttagService.selectAll();
        model.addAttribute("tags",ttags);
        return "admin/blogsUpdate";
    }

    @RequestMapping(value = "archives")
    public String archives(HttpServletRequest request){
        int selectcount = tblogService.selectcount();
        List<Tblog> tblogs = tblogService.selectAll();
        Map<String, List<Tblog>> map = tblogService.selectordecDate();
        pub(request,tblogService);
        request.setAttribute("archiveMap",map);
        request.setAttribute("blogCount",selectcount);
        return "archives";
    }


    @RequestMapping(value = "search")
    public String search(HttpServletRequest request, Page page, String query){
        page.setQuery(query);
        List<Tblog> tblogs = tblogService.selectLikeTitle(page);
        pub(request,tblogService);
        page.setList(tblogs);
        request.setAttribute("page",page);
        return "search";
    }

    public static void pub(HttpServletRequest request,TblogService tblogService){
        List<Tblog> selectRecommend =tblogService.selectRecommend();
        request.setAttribute("recommendBlogs",selectRecommend);
    }


    public static void getBlog(Long id, Model model,HttpServletRequest request,TblogService tblogService,TtagService ttagService,TcommentService tcommentService){
        Tblog tblog1 = tblogService.selectByPrimaryKey(id);
        Tblog tblog=new Tblog();
        BeanUtils.copyProperties(tblog1,tblog);
        String content = tblog1.getContent();
        tblog1.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        Integer views = tblog1.getViews()+1;
        tblog.setUpdateTime(new Date());
        tblog.setViews(views);
        tblog.setId(tblog1.getId());
        int insert = tblogService.updateByPrimaryKeySelective(tblog);
        List<Ttag> ttags = ttagService.selectAll();
        model.addAttribute("blog",tblog1);
        model.addAttribute("tags",ttags);
        List<Tcomment> tcomments1 = tcommentService.selectblogId(id);
        List<Tcomment> selectparent = tcommentService.selectparent(id);
        model.addAttribute("comments",tcomments1);
        model.addAttribute("replyComments",selectparent);
    }


}
