package com.ls.controller;

import com.ls.model.Department;
import com.ls.model.Train;
import com.ls.model.TrainNotice;
import com.ls.service.AttendanceService;
import com.ls.service.DepartmentService;
import com.ls.service.TrainNoticeService;
import com.ls.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LS on 2017/11/2 8:15.
 * To Be or Not to Be
 */
@Controller
public class TrainController {
    @Resource
    private TrainService trainService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private TrainNoticeService trainNoticeService;
    //添加培训信息
    @RequestMapping(value = "/addTrain",method = RequestMethod.POST)
    public String addTrain(Train train,Model model){
        trainService.addTrain(train);
        return queryAllTrain(model);
    }

    //查看所有培训信息
    @RequestMapping(value = "/queryAllTrain",method = RequestMethod.GET)
    public String queryAllTrain(Model model){
        List<Train> trains = trainService.queryAllTrain();
        model.addAttribute("trains",trains);
        return "page/train/trainList";
    }

    //删除某条培训信息
    @RequestMapping(value = "/deleteTrain",method = RequestMethod.GET)
    public String deleteTrain(int id,Model model){
        trainService.deleteTrain(id);
        trainNoticeService.deleteTrainNotice(id);
        model.addAttribute("info","删除成功");
        return queryAllTrain(model);
    }

    //回显某一条培训信息
    @RequestMapping(value = "/updateTrainJsp",method = RequestMethod.GET)
    public String updateTrainJsp(int id,Model model){
        Train train = trainService.queryTrainById(id);
        model.addAttribute("train",train);
        return "page/train/updateTrain";
    }


    //更新某条培训信息
    @RequestMapping(value = "/updateTrain",method = RequestMethod.POST)
    public String updateTrain(Train train,Model model){
        trainService.updateTrain(train);
        model.addAttribute("info","更新成功");
        return queryAllTrain(model);
    }

    //安排人员页面
    @RequestMapping(value = "/arrangePersonJsp",method = RequestMethod.GET)
    public String arrangePerson(int id,Model model){
        List<Department> departments = departmentService.queryAllDep();
        model.addAttribute("departments",departments);
//        System.out.println("department=="+departments);
        updateTrainJsp(id,model);
        return "page/train/arrangePerson";
    }

    //安排人员
    @RequestMapping(value = "/arrangePerson",method = RequestMethod.POST)
    public String arrange(int[] emId,Model model,int trainId){

        //安排培训
        List<TrainNotice> trainNotice = trainNoticeService.queryTrainById(trainId);
        if (trainNotice!=null){
            trainNoticeService.deleteTrainNotice(trainId);
        }
        if (emId!=null){
            for (int i = 0; i < emId.length; i++) {
                int empId = emId[i];
                TrainNotice notice = new TrainNotice();
                notice.setEmpId(empId);
                notice.setTrainId(trainId);
                trainNoticeService.arrangePerson(notice);
                model.addAttribute("info","安排成功");
            }
        }else {
            model.addAttribute("info","未安排人员");
        }
        String s = queryAllTrain(model);
        return s;
    }


    //安排人员页面
    @RequestMapping(value = "/queryTransById",method = RequestMethod.GET)
    public String queryTransById(int id,Model model){
        Train train = trainService.queryTrainById(id);
        List<TrainNotice> noticeList = trainNoticeService.queryTrainById(id);
        System.out.println("12345678=="+noticeList);
        model.addAttribute("train",train);
        model.addAttribute("noticeList",noticeList);
        return "page/train/showTrain";
    }
}
