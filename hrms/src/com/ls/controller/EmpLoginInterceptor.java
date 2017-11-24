package com.ls.controller;

import com.ls.model.Employee;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by LS on 2017/11/12 12:48.
 * To Be or Not to Be
 */
public class EmpLoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        Employee emp = (Employee) session.getAttribute("emp");
        if (emp==null){
            System.out.println("=====1122");
            request.getRequestDispatcher("companyLogin.jsp").forward(request,response);
            return false;
        }
        System.out.println("====2233");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
