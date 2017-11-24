package com.ls.service.impl;

import com.ls.dao.WorkDao;
import com.ls.model.Work;
import com.ls.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LS on 2017/11/2 15:10.
 * To Be or Not to Be
 */
@Transactional
@Service
public class WorkServiceImpl implements WorkService{
    @Autowired
    private WorkDao workDao;

    @Override
    public void saveWorkTime(Work work) {
        Work work1 = workDao.queryWork();
        if (work1!=null){
            work.setId(work1.getId());
            workDao.updateWork(work);
            return;
        }
        workDao.saveWordTime(work);
    }

    @Override
    public Work queryWork() {
        return workDao.queryWork();
    }
}
