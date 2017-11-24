package com.ls.controller;

import com.ls.model.Employee;
import com.ls.model.TrainNotice;
import com.ls.service.TrainNoticeService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Created by LS on 2017/11/2 8:15.
 * To Be or Not to Be
 */
@Controller
public class TrainNoticeController {
    @Resource
    private TrainNoticeService trainNoticeService;

    //查看是否有培训通知
    @RequestMapping(value = "/queryTrainByEmpId",method = RequestMethod.POST)
    public void queryTrainByEmpId(HttpServletResponse response, HttpSession session){
        Employee emp = (Employee) session.getAttribute("emp");
        List<TrainNotice> trainNotices = trainNoticeService.queryTrainByEmpId(emp.getId());
        JSONArray jsonArray = JSONArray.fromObject(trainNotices);
        try {
            response.getWriter().println(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //查看培训通知
    @RequestMapping(value = "/queryTrain",method = RequestMethod.GET)
    public String queryTrain(HttpSession session, Model model){
        Employee emp = (Employee) session.getAttribute("emp");
        List<TrainNotice> trainNotices = trainNoticeService.queryTrainByEmpId(emp.getId());
        model.addAttribute("trainNotices",trainNotices);
        return "page/train/empTrainList";
    }
}
