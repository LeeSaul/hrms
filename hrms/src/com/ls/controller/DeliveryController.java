package com.ls.controller;

import com.ls.model.Delivery;
import com.ls.model.Recruitment;
import com.ls.model.Resume;
import com.ls.model.Tourist;
import com.ls.service.DeliveryService;
import com.ls.service.RecruitmentService;
import com.ls.service.ResumeService;
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
 * Created by LS on 2017/10/30 14:44.
 * To Be or Not to Be
 */
@Controller
public class DeliveryController {

    @Resource
    private ResumeService resumeService;

    @Resource
    private DeliveryService deliveryService;

    @Resource
    private RecruitmentService recruitmentService;

    //游客投递简历
    @RequestMapping(value = "/delivery",method = RequestMethod.GET)
    public String deliveryResume(int recId, HttpSession session, Model model){
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        Resume resume1 = resumeService.queryResume(tourist.getId());
        if(resume1==null){
            return "forward:/queryMyResume";
        }
        int tourId = tourist.getId();
        Resume resume = resumeService.queryResume(tourId);
        Delivery deliveryTemp=new Delivery();
        deliveryTemp.setRecId(recId);
        deliveryTemp.setResumeId(resume.getId());
        Delivery delivery = deliveryService.queryByReIdAndRecId(deliveryTemp);
        String info="";
        if (delivery!=null){
            info="已投递过该岗位，无需重复投递！";
        }else {
            deliveryTemp.setStatus(Delivery.HASDELIVER);
            deliveryService.saveDelivery(deliveryTemp);
            info="投递成功";
        }
        model.addAttribute("info",info);
        return "aRecruitment";
    }

    //查看所有简历
    @RequestMapping(value = "/queryAllResume",method = RequestMethod.GET)
    public String queryAllResume(Model model){
        List<Delivery> deliveries = deliveryService.queryAllDelivery();
        model.addAttribute("deliveries",deliveries);
        return "page/resume/cvIndex";
    }

    //发送邀请
    @RequestMapping(value = "/sendInvitation",method = RequestMethod.GET)
    public String ensureInvitation(int id,Model model){
        Delivery temp=new Delivery();
        temp.setId(id);
        temp.setStatus(Delivery.SENDINVITATION);
        deliveryService.updateDelivery(temp);
        Delivery delivery = deliveryService.queryDelivery(id);
        Resume resume = resumeService.queryDetailResume(delivery.getResumeId());
        Recruitment recruitment = recruitmentService.queryRecruitmentById(delivery.getRecId());

        delivery.setResume(resume);
        delivery.setRecruitment(recruitment);
        model.addAttribute("delivery",delivery);
        model.addAttribute("info","邀请成功");
        return "page/resume/aDelivery";
    }
    //确认录用
    @RequestMapping(value = "/sendHired",method = RequestMethod.GET)
    public String sendHired(int id,Model model){
        Delivery temp=new Delivery();
        temp.setId(id);
        temp.setStatus(Delivery.ADMISSION);
        deliveryService.updateDelivery(temp);
        Delivery delivery = deliveryService.queryDelivery(id);
        Resume resume = resumeService.queryDetailResume(delivery.getResumeId());
        Recruitment recruitment = recruitmentService.queryRecruitmentById(delivery.getRecId());

        delivery.setResume(resume);
        delivery.setRecruitment(recruitment);
        model.addAttribute("delivery",delivery);
        model.addAttribute("info","录用成功");
        return "page/resume/aDelivery";
    }

    //拒绝录用
    @RequestMapping(value = "/sendRefuse",method = RequestMethod.GET)
    public String sendRefuse(int id,Model model){
        Delivery temp=new Delivery();
        temp.setId(id);
        temp.setStatus(Delivery.REFUSE);
        deliveryService.updateDelivery(temp);
        Delivery delivery = deliveryService.queryDelivery(id);
        Resume resume = resumeService.queryDetailResume(delivery.getResumeId());
        Recruitment recruitment = recruitmentService.queryRecruitmentById(delivery.getRecId());

        delivery.setResume(resume);
        delivery.setRecruitment(recruitment);
        model.addAttribute("delivery",delivery);
        model.addAttribute("info","已拒绝");
        return "page/resume/aDelivery";
    }
    //拒绝参加
    @RequestMapping(value = "/sendTourRefuse",method = RequestMethod.GET)
    public String sendTourRefuse(int id,Model model){
        Delivery temp=new Delivery();
        temp.setId(id);
        temp.setStatus(Delivery.REFUSE);
        deliveryService.updateDelivery(temp);
        Delivery delivery = deliveryService.queryDelivery(id);
        Resume resume = resumeService.queryDetailResume(delivery.getResumeId());
        Recruitment recruitment = recruitmentService.queryRecruitmentById(delivery.getRecId());

        delivery.setResume(resume);
        delivery.setRecruitment(recruitment);
        model.addAttribute("delivery",delivery);
        model.addAttribute("info","已拒绝");
        return "page/resume/aTourDelivery";
    }

    //查看某个游客的投递记录
    @RequestMapping(value = "/queryDeliveryByTourist",method = RequestMethod.GET)
    public String queryDeliveryByTourist(Model model,HttpSession session){
        Delivery delivery=new Delivery();
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        Resume resume = resumeService.queryResume(tourist.getId());
        if (resume==null){
            model.addAttribute("info","暂无投递记录");
            return "page/tour/resume";
        }
        List<Delivery> deliveries = deliveryService.queryDeliveryByResumeId(resume.getId());
        resume.setDeliveries(deliveries);
        System.out.println("id"+deliveries);
        model.addAttribute("resume",resume);
        model.addAttribute("deliveries",deliveries);
//        session.setAttribute("",deliveries);
        return "page/tour/resume";
    }

    //管理员查看某个状态的简历
    @RequestMapping(value = "/queryResumeByStatus",method = RequestMethod.GET)
    public String queryResumeByStatus(Model model,String status){
        String s="";
        if (status.equals("notRed")){
            s=Delivery.HASDELIVER;
        }else if (status.equals("red")){
            s=Delivery.HASRED;
        }else if(status.equals("send")){
            s=Delivery.SENDINVITATION;
        }else if(status.equals("notConfirm")){
            s=Delivery.NOTCONFIRM;
        }else if(status.equals("confirm")){
            s=Delivery.WAITING;
        }else if(status.equals("hire")){
            s=Delivery.ADMISSION;
        }else if (status.equals("refuse")){
            s=Delivery.REFUSE;
        }
        List<Delivery> deliveries = deliveryService.queryDepByStatus(s);
        model.addAttribute("deliveries",deliveries);
        return "page/resume/cvIndex";
    }


    //确认面试
    @RequestMapping(value = "/ensureInvitation",method = RequestMethod.GET)
    public String ensureSend(int id,Model model){
        Delivery delivery=new Delivery();
        delivery.setId(id);
        delivery.setStatus(Delivery.WAITING);
        deliveryService.updateDelivery(delivery);
        model.addAttribute("info","确认成功");
        return "forward:/queryDeliveryByTourist";
    }

    //管理员查看某一份简历
    @RequestMapping(value = "/queryDetailDelivery",method = RequestMethod.GET)
    public String queryDetailDelivery(int id,Model model){
        Delivery delivery = deliveryService.queryDelivery(id);
        if(delivery.getStatus().equals(Delivery.HASDELIVER)){
            String s=Delivery.HASRED;
            delivery.setStatus(s);
        }
        deliveryService.updateDelivery(delivery);

        Resume resume = resumeService.queryDetailResume(delivery.getResumeId());
        Recruitment recruitment = recruitmentService.queryRecruitmentById(delivery.getRecId());
        delivery.setResume(resume);
        delivery.setRecruitment(recruitment);
        model.addAttribute("delivery",delivery);
        return "page/resume/aDelivery";
    }

    //游客查看某一份简历
    @RequestMapping(value = "/queryDetailDeliveryById",method = RequestMethod.GET)
    public String queryDetailDeliveryById(int id,Model model){
        Delivery delivery = deliveryService.queryDelivery(id);
        /*if(delivery.getStatus().equals(Delivery.HASDELIVER)){
            String s=Delivery.HASRED;
            delivery.setStatus(s);
        }
        deliveryService.updateDelivery(delivery);*/

        Resume resume = resumeService.queryDetailResume(delivery.getResumeId());
        Recruitment recruitment = recruitmentService.queryRecruitmentById(delivery.getRecId());
        delivery.setResume(resume);
        delivery.setRecruitment(recruitment);
        model.addAttribute("delivery",delivery);
        return "page/resume/aTourDelivery";
    }
}
