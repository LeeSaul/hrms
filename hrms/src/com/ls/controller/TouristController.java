package com.ls.controller;

import com.ls.model.Tourist;
import com.ls.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LS on 2017/10/26 12:33.
 * To Be or Not to Be
 */
@Controller
public class TouristController {
    @Resource
    private TouristService touristService;

    //ajax�жϸ��û����Ƿ��Ѿ���ע��
    @RequestMapping(value = "/queryTouristName",method = RequestMethod.POST)
    public void queryTouristName(String tourName, HttpServletResponse response) throws IOException {
        boolean b = touristService.queryTouristName(tourName);
        if (b){
            response.getWriter().write("�Ѵ���");
        }else {
            response.getWriter().write("����");
        }
    }

    //ע���ο��˺�
    @RequestMapping(value = "/tourRegister",method = RequestMethod.POST)
    public String tourRegister(Tourist tourist){
        boolean b = touristService.tourRegister(tourist);
        if (b){
            return "main";
        }
        return "fail";
    }

    //�ο͵�¼
    @RequestMapping(value = "/tourLogin",method = RequestMethod.POST)
    public String tourLogin(Tourist tourist, HttpSession session, Model model){
        tourist= touristService.tourLogin(tourist);
        String info="";
        if (tourist!=null){
            session.setAttribute("tourist",tourist);
            model.addAttribute("info",info);
            return "page/tour/tourIndex";
        }else{
            info="�û������������";
            model.addAttribute("info",info);
            return "page/tour/tourLogin";
        }
    }

    //�ο͵�¼
    @RequestMapping(value = "/isNeedLogin",method = RequestMethod.GET)
    public String isNeedLogin(HttpSession session, Model model){
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        if (tourist!=null){
            return "page/tour/tourIndex";
        }else{
            return "page/tour/tourLogin";
        }
    }

    //�ο͵�¼
    @RequestMapping(value = "/touristExitLogin",method = RequestMethod.GET)
    public String touristExitLogin(HttpSession session, Model model){
        session.setAttribute("tourist",null);
        return "main";
    }
}
