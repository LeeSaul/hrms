package com.ls.service.impl;

import com.ls.dao.ResumeDao;
import com.ls.model.Resume;
import com.ls.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LS on 2017/10/26 16:56.
 * To Be or Not to Be
 */
@Transactional
@Service
public class ResumeServiceImpl implements ResumeService{
    @Autowired
    private ResumeDao resumeDao;

    @Override
    public boolean addResume(Resume resume) {
        return resumeDao.addResume(resume);
    }

    @Override
    public Resume queryResume(int tourId) {
        return resumeDao.queryResume(tourId);
    }

    @Override
    public Resume queryDetailResume(int id) {
        return resumeDao.queryDetailResume(id);
    }

    @Override
    public void updateResume(Resume resume) {
        resumeDao.updateResume(resume);
    }

    @Override
    public void updateEmpResume(Resume resume) {
        resumeDao.updateEmpResume(resume);
    }
}
