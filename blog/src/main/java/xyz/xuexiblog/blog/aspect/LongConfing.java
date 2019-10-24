package xyz.xuexiblog.blog.aspect;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xyz.xuexiblog.blog.pojp.Tuser;
import xyz.xuexiblog.blog.util.MD5Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class LongConfing implements HandlerInterceptor {


    //在请求处理之前进行调用（Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest Request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle被调用");
        HttpSession session = Request.getSession();
        Tuser user = (Tuser) session.getAttribute("user");

        if (user!=null) {
            Cookie session1 =new Cookie("session",session.getId());
            Cookie cookie =new Cookie("name",user.getUsername());
            Cookie nuam =new Cookie("pwd", MD5Utils.code(user.getPassword()));
            cookie.setMaxAge(3600000);
            nuam.setMaxAge(3600000);
            if (user==null&&cookie.getValue()==null&&nuam.getValue()==null){
                String value = cookie.getValue();
                String value1 = nuam.getValue();
                httpServletResponse.sendRedirect("/login1");
                return false;
            }else {
                session.setMaxInactiveInterval(36000);
                return true;
            }
        }else {
            httpServletResponse.sendRedirect("/login1");
            return false;
        }

    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle被调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion被调用");
    }
}
