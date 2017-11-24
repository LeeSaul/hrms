package com.ls.service.impl;

import com.ls.dao.SalaryDao;
import com.ls.dao.SuggestDao;
import com.ls.model.Salary;
import com.ls.model.Suggest;
import com.ls.service.SuggestService;
import com.ls.util.WorkDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LS on 2017/11/8 9:08.
 * To Be or Not to Be
 */
@Service
@Transactional
public class SuggestServiceImpl implements SuggestService{
    @Autowired
    private SuggestDao suggestDao;
    @Autowired
    private SalaryDao salaryDao;
    @Override
    public void addSuggest(Suggest suggest) {
        suggestDao.addSuggest(suggest);
    }

    @Override
    public List<Suggest> querySuggest(int empId) {
        return suggestDao.querySuggest(empId);
    }

    @Override
    public List<Suggest> queryAllSuggest() {
        return suggestDao.queryAllSuggest();
    }

    @Override
    public void agreeSuggest(int empId,int id, int money) {
        String s = WorkDate.currentMonth();
        Salary salary=new Salary();
        salary.setPerformancePay(money);
        salary.setEmpId(empId);
        salary.setCreateDate(s);
        System.out.println("s======"+s);
        Salary temp = salaryDao.queryCurrentSalary(empId,s);
        if (temp!=null){
            temp.setPerformancePay(money);
            salaryDao.updateSocialRePun(temp);
        }else {
            salaryDao.saveSalary(salary);
        }
        Suggest suggest=new Suggest();
        suggest.setId(id);
        suggest.setStatus(Suggest.agreeStatus);
        suggestDao.updateSuggest(suggest);
    }

    @Override
    public void refuseSuggest(int id) {
        Suggest suggest=new Suggest();
        suggest.setId(id);
        suggest.setStatus(Suggest.refuseStatus);
        suggestDao.updateSuggest(suggest);
    }

}
