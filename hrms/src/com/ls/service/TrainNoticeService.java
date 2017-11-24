package com.ls.service;

import com.ls.model.TrainNotice;

import java.util.List;

/**
 * Created by LS on 2017/11/2 8:16.
 * To Be or Not to Be
 */
public interface TrainNoticeService {
    List<TrainNotice> queryTrainById(int trainId);

    void deleteTrainNotice(int trainId);

    void arrangePerson(TrainNotice trainNotice);

    List<TrainNotice> queryTrainByEmpId(int id);
}
