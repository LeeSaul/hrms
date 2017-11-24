package com.ls.dao;

import com.ls.model.TrainNotice;

import java.util.List;

/**
 * Created by LS on 2017/11/2 8:17.
 * To Be or Not to Be
 */
public interface TrainNoticeDao {
    void deleteTrainNotice(int trainId);

    List<TrainNotice> queryTrainById(int trainId);

    void arrangePerson(TrainNotice trainNotice);

    List<TrainNotice> queryTrainByEmpId(int id);

}
