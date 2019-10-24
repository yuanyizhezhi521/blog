package xyz.xuexiblog.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.xuexiblog.blog.pojp.Ttag;
import xyz.xuexiblog.blog.pojp.Ttype;
import xyz.xuexiblog.blog.service.TtagService;
import xyz.xuexiblog.blog.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "tag")
public class TtagController {
    @Autowired
    TtagService ttagService;

    /**
     * 标签添加页面跳转
     * @return
     */
    @RequestMapping(value = "add")
    public String ttag(){
        return "admin/tags-input";
    }

    /**
     * 标签添加
     * @param ttag
     * @return
     */
    @RequestMapping(value = "insert")
    public String insert(Ttag ttag){
        int insert = ttagService.insert(ttag);
        return "forward:/admin/tags";
    }

    /**
     * 标签修改页面条治安
     * @param ttag
     * @param request
     * @return
     */
    @RequestMapping("/updateinput/{id}/")
    public String updateinput(Ttag ttag, HttpServletRequest request){
        Ttag ttag1 = ttagService.selectByPrimaryKey(ttag.getId());
        request.setAttribute("id",ttag1.getId());
        request.setAttribute("name",ttag1.getName());
        return "admin/tags-input";
    }

    /**
     * 标签修改
     * @param ttag
     * @return
     */
    @RequestMapping(value = "update/{id}")
    public String update(Ttag ttag){
        int insert = ttagService.updateByPrimaryKey(ttag);
        return "forward:/admin/tags";
    }

    /**
     * 删除标签
     * 不完整
     * @param ttag
     * @return
     */
    @RequestMapping(value = "delect/{id}")
    public String delect(Ttag ttag){
        int insert = ttagService.deleteByPrimaryKey(ttag.getId());
        return "forward:/admin/tags";
    }

    @RequestMapping(value = "select")
    public String select(Ttype ttype,HttpServletRequest request){
        List<Ttag> ttypes = ttagService.selectAll();
        int i = ttagService.selectByBlog();
        Page page=new Page();
        page.setTotalRecord(i);
        List<Ttag> tblogs = ttagService.selectAllByTagId(page);
        page.setList(tblogs);
        page.setTotalPage(page.TotalPage(page.getTotalRecord(),page.getCurrentCount()));
        obj(ttypes,i,page,request);
        return "tags";
    }

    @RequestMapping("/{id}")
    public String selectByID(Ttype ttype,Page page,HttpServletRequest request){
        List<Ttag> ttags = ttagService.selectAll();
        page.setTid(ttype.getId());
        List<Ttag> ttags1 = ttagService.selectAllByTagId(page);
        page.setList(ttags1);
        int i = ttagService.selectByBlog();
        obj(ttags,i,page,request);
        return "tags";
    }


    static void obj(List<?> ttags, int i, Page page,HttpServletRequest request ) {
        request.setAttribute("tags",ttags);
        request.setAttribute("countty",i);
        request.setAttribute("page",page);
    }


}
