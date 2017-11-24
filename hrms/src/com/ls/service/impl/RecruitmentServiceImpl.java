package com.ls.service.impl;

import com.ls.dao.DeliveryDao;
import com.ls.dao.RecruitmentDao;
import com.ls.dao.ResumeDao;
import com.ls.model.Delivery;
import com.ls.model.Recruitment;
import com.ls.model.Resume;
import com.ls.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/10/27 14:54.
 * To Be or Not to Be
 */
@Transactional
@Service
public class RecruitmentServiceImpl implements RecruitmentService{
    @Autowired
    private RecruitmentDao recruitmentDao;
    @Autowired
    private ResumeDao resumeDao;
    @Autowired
    private DeliveryDao deliveryDao;

    @Override
    public boolean addRecruitment(Recruitment recruitment) {
        return recruitmentDao.addRecruitment(recruitment);
    }

    @Override
    public List<Recruitment> queryRecruitment() {
        List<Recruitment> recruitments = recruitmentDao.queryRecruitment();
       if (recruitments!=null){
           for (int i = 0; i < recruitments.size(); i++) {
               Recruitment recruitment = recruitments.get(i);
               List<Delivery> deliveries = deliveryDao.queryDeliveryByRecId(recruitment.getId());
               List<Resume> resumes=new ArrayList<>();
               for (Delivery delivery : deliveries) {
                   Resume resume = resumeDao.queryDetailResume(delivery.getResumeId());
                   resumes.add(resume);
               }
               recruitment.setResume(resumes);
           }
           return recruitments;
       }
       return null;

    }

    @Override
    public Recruitment queryRecruitmentById(int id) {
        return recruitmentDao.queryRecruitmentById(id);
    }

    @Override
    public void updateRecruitment(Recruitment recruitment) {
        recruitment.setCreateDate(new Timestamp(System.currentTimeMillis()));
        recruitmentDao.updateRecruitment(recruitment);
    }

    @Override
    public List<Resume> queryResume(int id) {

        List<Delivery> deliveries = deliveryDao.queryDeliveryByRecId(id);
        System.out.println("1212"+deliveries);
        List<Resume> resumes=new ArrayList<>();
        for (Delivery delivery : deliveries) {
            Resume resume = resumeDao.queryDetailResume(delivery.getResumeId());
            resumes.add(resume);
        }
        System.out.println("2323"+resumes);
        return resumes;
    }

    @Override
    public void deleteRecruitmentById(int id) {
        //删除招聘信息同时也删除投递记录
        int recId=id;
        recruitmentDao.deleteRecruitmentById(id);
        deliveryDao.deleteDeliveryByRecId(recId);
    }
}
