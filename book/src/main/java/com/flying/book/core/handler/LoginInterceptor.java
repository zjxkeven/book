package com.flying.book.core.handler;

import com.flying.book.core.OnlyAdmin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    public  static final String USER_OBJECT = "Authorization";
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");

        // 请求的方法是否有注解
        boolean haveAnnotataion = handler.getClass().isAssignableFrom(HandlerMethod.class);
        if (haveAnnotataion) {
            // 检测是否有 @OnlyAdmin 注解
            OnlyAdmin oa = ((HandlerMethod)handler).getMethodAnnotation(OnlyAdmin.class);
            if (oa != null) {
                // 如果有 @OnlyAdmin则表明该方法只允许管理员删除
                Object token = request.getHeader(USER_OBJECT);
                if (token==null || !"Bearer admin".equals(token.toString())) { // 这里假设管理员token为admin
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/json;charset=utf-8");
                    PrintWriter pw = response.getWriter();
                    pw.flush();
                    pw.println("{\"msg\":\"你未有该权限\"}");
                    return false;
                }
            }
        }
        // 用户已登录，则返回true, 放行该请求
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        super.afterCompletion(request, response, handler, ex);
        System.out.println("afterCompletion");
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        super.postHandle(request, response, handler, modelAndView);
        System.out.println("postHandle");
    }

}
