package xyz.xuexiblog.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.xuexiblog.blog.pojp.Tblog;
import xyz.xuexiblog.blog.pojp.Tcomment;
import xyz.xuexiblog.blog.pojp.Tuser;
import xyz.xuexiblog.blog.service.TblogService;
import xyz.xuexiblog.blog.service.TcommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class TcommentController {
    @Autowired
    TcommentService tcommentService;
    @Autowired
    TblogService tblogService;
    @RequestMapping(value = "comments")
    @ResponseBody
    public HttpServletRequest tcommeInsert(Tcomment tcomment, HttpSession session, HttpServletRequest request){
        tcomment.setCreateTime(new Date());
        String parameter = request.getParameter("blog.id");
        String parameter1 = request.getParameter("parentCommentId");
        if (parameter1!=null){
            Long commentID =Long.parseLong(parameter1);
            if (commentID>0){
                tcomment.setParentCommentId(commentID);
            }
        }else {
            tcomment.setParentCommentId(null);
        }
        long blogid = Long.parseLong(parameter);
        tcomment.setBlogId(blogid);
        Tuser user = (Tuser) session.getAttribute("user");
        tcomment.setAvatar(user.getAvatar());
        String adminComment = request.getParameter("adminComment");
        Tblog tblog = tblogService.selectByPrimaryKey(blogid);
        if (blogid==tblog.getId()){
            tcomment.setAdminComment(true);
        }else {
            tcomment.setAdminComment(false);
        }

        int insert = tcommentService.insert(tcomment);
        List<Tcomment> tcomments = tcommentService.selectblogId(blogid);

        if (insert>0){
            List<Tcomment> tcomments1 = tcommentService.selectblogId(blogid);
            List<Tcomment> parent_comment_id= tcommentService.selectparent_comment_id(blogid);
            request.setAttribute("comments",tcomments1);
            request.setAttribute("replyComments",parent_comment_id);
            return request;
        }else {
            request.setAttribute("msge","网络出现波动或服务器君发呆了");
            return request;
        }

    }
}
