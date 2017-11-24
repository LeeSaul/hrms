package com.ls.controller;

import com.ls.model.Employee;
import com.ls.model.Suggest;
import com.ls.service.SuggestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by LS on 2017/11/8 9:07.
 * To Be or Not to Be
 */
@Controller
public class SuggestController {
    @Resource
    private SuggestService suggestService;

    //���
    @RequestMapping(value = "/addSuggest",method = RequestMethod.GET)
    public String  addSuggest(String suggestInfo,HttpSession session){
        Employee emp = (Employee) session.getAttribute("emp");
        Suggest suggest=new Suggest();
        suggest.setEmpId(emp.getId());
        suggest.setSuggestInfo(suggestInfo);
        suggest.setStatus(Suggest.reviewStatus);
        suggestService.addSuggest(suggest);
        return "forward:/querySuggest";
    }
    //Ա���鿴�Լ��ĸ������
    @RequestMapping(value = "/querySuggest",method = RequestMethod.GET)
    public String querySuggest(Model model,HttpSession session){
        Employee emp = (Employee) session.getAttribute("emp");
        List<Suggest> suggests = suggestService.querySuggest(emp.getId());
        model.addAttribute("suggests",suggests);
        return "page/emp/querySuggest";
    }

    //����Ա�鿴�������
    @RequestMapping(value = "/queryAllSuggest",method = RequestMethod.GET)
    public String queryAllSuggest(Model model,HttpSession session){
        List<Suggest> suggests = suggestService.queryAllSuggest();
        model.addAttribute("suggests",suggests);
        return "page/admin/allSuggest";
    }

    //����Աͬ�����������ӹ���ҳ��
    @RequestMapping(value = "/agreeSuggest",method = RequestMethod.GET)
    public String agreeSuggest(int id,int empId,Model model){
        model.addAttribute("empId",empId);
        model.addAttribute("id",id);
        return "page/emp/suggestMoney";
    }

    //����Աͬ������ӹ���
    @RequestMapping(value = "/addExtraSalary",method = RequestMethod.GET)
    public String addExtraSalary(int empId,int salary,int id,Model model){
        suggestService.agreeSuggest(empId,id,salary);
        model.addAttribute("empId",empId);
        return "forward:/queryAllSuggest";
    }

    //����Ա�ܾ�����
    @RequestMapping(value = "/refuseSuggest",method = RequestMethod.GET)
    public String refuseSuggest(int id){
        suggestService.refuseSuggest(id);
        return "forward:/queryAllSuggest";
    }
}
