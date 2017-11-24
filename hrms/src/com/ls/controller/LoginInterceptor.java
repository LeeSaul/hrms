package com.ls.controller;

import com.ls.model.Tourist;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by LS on 2017/11/12 12:20.
 * To Be or Not to Be
 */
public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        if (tourist==null){
            request.getRequestDispatcher("page/tour/tourLogin.jsp").forward(request,response);
            System.out.println("游客错了");
            return false;
        }
        System.out.println("游客正确");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
