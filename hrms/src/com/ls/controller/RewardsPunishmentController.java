package com.ls.controller;

import com.ls.model.RewardsPunishment;
import com.ls.service.AttendanceService;
import com.ls.service.RewardsPunishmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LS on 2017/11/2 15:07.
 * To Be or Not to Be
 */
@Controller
public class RewardsPunishmentController {
    @Resource
    private RewardsPunishmentService rewardsPunishmentService;
    @Resource
    private AttendanceService attendanceService;

    @RequestMapping(value = "/queryRewardsPun",method = RequestMethod.GET)
    public String queryRewardsPun(Model model){
        List<RewardsPunishment> repuns=rewardsPunishmentService.queryRewardsPun();
        model.addAttribute("repuns",repuns);
        return "page/admin/repuns";
    }
}
