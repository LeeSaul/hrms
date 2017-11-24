package com.ls.service.impl;

import com.ls.dao.TrainNoticeDao;
import com.ls.model.Train;
import com.ls.model.TrainNotice;
import com.ls.service.TrainNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LS on 2017/11/2 8:16.
 * To Be or Not to Be
 */
@Transactional
@Service
public class TrainNoticeServiceImpl implements TrainNoticeService{
    @Autowired
    private TrainNoticeDao trainNoticeDao;

    @Override
    public List<TrainNotice> queryTrainById(int trainId) {
        return trainNoticeDao.queryTrainById(trainId);
    }

    @Override
    public void deleteTrainNotice(int trainId) {
        trainNoticeDao.deleteTrainNotice(trainId);
    }

    @Override
    public void arrangePerson(TrainNotice trainNotice) {
        trainNoticeDao.arrangePerson(trainNotice);
    }

    @Override
    public List<TrainNotice> queryTrainByEmpId(int id) {
        return trainNoticeDao.queryTrainByEmpId(id);
    }
}
