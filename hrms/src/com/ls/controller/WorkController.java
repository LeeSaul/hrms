package com.ls.controller;

import com.ls.model.Work;
import com.ls.model.WorkDay;
import com.ls.service.WorkService;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;
import org.apache.struts2.json.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/11/2 15:15.
 * To Be or Not to Be
 */
@Controller
public class WorkController {
    @Resource
    private WorkService workService;
    @RequestMapping(value = "/saveWordTime",method = RequestMethod.POST)
    public String saveWordTime(Work work, Model model){
        workService.saveWorkTime(work);
        model.addAttribute("info","±£´æ³É¹¦");
        return "page/time/work";
    }

    @RequestMapping(value = "/queryWorkTime",method = RequestMethod.GET)
    public String queryWorkTime(Model model){
        Work work = workService.queryWork();
        System.out.println("=!"+work);
        if (work!=null){
            model.addAttribute("work",work);
        }
        return "page/time/work";
    }


}
