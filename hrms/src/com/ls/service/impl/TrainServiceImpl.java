package com.ls.service.impl;

import com.ls.dao.TrainDao;
import com.ls.dao.TrainNoticeDao;
import com.ls.model.Train;
import com.ls.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/11/2 8:17.
 * To Be or Not to Be
 */
@Transactional
@Service
public class TrainServiceImpl implements TrainService{
    @Autowired
    private TrainDao trainDao;
    @Autowired
    private TrainNoticeDao trainNoticeDao;

    @Override
    public void addTrain(Train train) {
        Date date=new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String format = simpleDateFormat.format(date);
        train.setCreateTime(format);
        trainDao.addTrain(train);
    }

    @Override
    public List<Train> queryAllTrain() {
        return trainDao.queryAllTrain();
    }

    @Override
    public void deleteTrain(int id) {
        //删除培训信息
        trainDao.deleteTrain(id);
        //删除通知
        trainNoticeDao.deleteTrainNotice(id);
    }

    @Override
    public void updateTrain(Train train) {
        Date date=new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String format = simpleDateFormat.format(date);
        train.setCreateTime(format);
        trainDao.updateTrain(train);
    }

    @Override
    public Train queryTrainById(int id) {
        return trainDao.queryTrainById(id);
    }
}
