package xyz.xuexiblog.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.xuexiblog.blog.pojp.Ttype;
import xyz.xuexiblog.blog.service.TblogService;
import xyz.xuexiblog.blog.service.TtypeService;
import xyz.xuexiblog.blog.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
@RequestMapping(value = "type")
public class TtypeController {
    @Autowired
    TtypeService ttypeService;
    @Autowired
    TblogService tblogService;

    /**
     * 分类添加页面
     * @return
     */
    @RequestMapping(value = "add")
    public String TypeInserthtml(HttpServletRequest request){
        Ttype ttype = ttypeService.selectByPrimaryKey(null);
//        ttype.setId(0l);
//        ttype.setName("请输入");
        request.setAttribute("type",ttype);
        return "admin/type-insert";
    }

    /**
     * 分类添加
     * @param ttype
     * @return
     */
    @RequestMapping(value = "insert")
    public String TypeInsert(Ttype ttype){
        int insert = ttypeService.insert(ttype);
        return "forward:/admin/types";
    }

    /**
     * 分了修改页面
     * @param ttype
     * @param request
     * @return
     */
    @RequestMapping(value = "updateinput/{id}")
    public String updateinput(Ttype ttype, HttpServletRequest request){
        Ttype ttag1 = ttypeService.selectByPrimaryKey(ttype.getId());
        System.out.println(ttag1.getName());
        request.setAttribute("type",ttag1);
        return "admin/types-input";
    }

    /**
     * 分类修改
     * @param ttype
     * @return
     */
    @RequestMapping(value = "update/{id}")
    public String update(Ttype ttype){
        int insert = ttypeService.updateByPrimaryKey(ttype);
        return "forward:/admin/types";
    }

    /**
     * 分类删除
     * @param ttype
     * @return
     */
    @RequestMapping(value = "delete/{id}")
    public String delect(Ttype ttype){
        int insert = ttypeService.deleteByPrimaryKey(ttype.getId());
        return "forward:/admin/types";
    }

    /**
     * types
     * @param ttype
     * @return
     */
    @RequestMapping(value = "select")
    public String select(Ttype ttype,Page page,HttpServletRequest request){
        List<Ttype> ttypes = ttypeService.selectAll();
        int i = ttypeService.selectByBlog();
        page.setTotalRecord(i);
        List<Ttype> tblogs = ttypeService.selectAllByTypeId(page);
        page.setList(tblogs);
        page.setTotalPage(page.TotalPage(page.getTotalRecord(),page.getCurrentCount()));
        request.setAttribute("types",ttypes);
        request.setAttribute("countty",i);
        request.setAttribute("page",page);
        return "types";
    }

    @RequestMapping("/types/{id}")
    public String selectByID(Ttype ttype,Page page,HttpServletRequest request){
        List<Ttype> ttypes = ttypeService.selectAll();
        page.setTid(ttype.getId());
        List<Ttype> tblogs = ttypeService.selectAllByTypeId(page);
        page.setList(tblogs);
        int i = ttypeService.selectByBlog();
        request.setAttribute("types",ttypes);
        request.setAttribute("countty",i);
        request.setAttribute("page",page);
        return "types";
    }
}
