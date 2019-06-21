package com.xjtu.servlet;

import com.xjtu.pojo.User;
import com.xjtu.service.UserService;
import com.xjtu.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init() throws ServletException {
        /*传统方式*/
        /*获取Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) ac.getBean("us");*/
        //优化方式
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        userService = (UserService) ac.getBean("us");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置相应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //处理请求信息
        //调用方法处理请求
        User u = userService.checkUserInfoService(uname,pwd);
        //响应处理结果
        if(u!=null){
            resp.getWriter().write("登录成功");
        }
    }
}
