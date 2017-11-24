package com.ls.controller;

import com.ls.model.Recruitment;
import com.ls.model.Resume;
import com.ls.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/10/27 14:53.
 * To Be or Not to Be
 */
@Controller
public class RecruitmentController {
    @Resource
    private RecruitmentService recruitmentService;


    //�����Ƹ��Ϣ
    @RequestMapping(value = "/addRecruitment",method = RequestMethod.POST)
    public String addRecruitment(Recruitment recruitment){
        Timestamp createdDate=new Timestamp(System.currentTimeMillis());
        recruitment.setCreateDate(createdDate);
        boolean b = recruitmentService.addRecruitment(recruitment);
        return "page/recruitment/recruitmentIndex";
    }

    //�鿴��Ƹ��Ϣ
    @RequestMapping(value = "/queryRecruitment",method = RequestMethod.GET)
    public String queryRecruitment(HttpSession session){
        List<Recruitment> recruitments = recruitmentService.queryRecruitment();
        session.setAttribute("recruitments",recruitments);
        return "recruitment";
    }

    //�鿴������Ƹ��Ϣ
    @RequestMapping(value = "/queryRecruitmentById",method = RequestMethod.GET)
    public String queryRecruitmentById(int id, HttpSession session, Model model){
        Recruitment recruitment = recruitmentService.queryRecruitmentById(id);
        session.setAttribute("recruitment",recruitment);
        return "aRecruitment";
    }

    //����Ա�鿴��Ƹ��Ϣ
    @RequestMapping(value = "/queryAllRecruitment",method = RequestMethod.GET)
    public String queryAllRecruitment(HttpSession session){
        List<Recruitment> recruitments = recruitmentService.queryRecruitment();
        session.setAttribute("recruitments",recruitments);
        return "page/recruitment/recruitmentIndex";
    }



    //������Ƹ��Ϣ--����
    @RequestMapping(value = "/updateRecByIdJsp",method = RequestMethod.GET)
    public String updateRecByIdJsp(int id,Model model){
        Recruitment recruitment = recruitmentService.queryRecruitmentById(id);
        model.addAttribute("recruitment",recruitment);
        return "page/recruitment/updateRecruitment";
    }

    //������Ƹ��Ϣ
    @RequestMapping(value = "/updateRecById",method = RequestMethod.GET)
    public String updateRecById(Recruitment recruitment,Model model){
        recruitmentService.updateRecruitment(recruitment);
        model.addAttribute("recruitment",recruitment);
        return "forward:/queryAllRecruitment";
    }

    //�鿴��Ͷ�ݼ���
    @RequestMapping(value = "/queryARec",method = RequestMethod.GET)
    public String queryARec(int id,Model model){
        System.out.println("==111"+id);
        List<Resume> resumes = recruitmentService.queryResume(id);
        System.out.println("==123"+resumes);
        model.addAttribute("resumes",resumes);
        return "page/recruitment/resumesOfaRecruitment";
    }

    //ɾ����Ƹ��Ϣ
    @RequestMapping(value = "/deleteRecById",method = RequestMethod.GET)
    public String deleteRecById(int id,Model model){
       recruitmentService.deleteRecruitmentById(id);
        return "forward:/queryAllRecruitment";
    }
}
