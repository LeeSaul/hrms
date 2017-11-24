package com.ls.service;

import com.ls.model.Train;

import java.util.List;

/**
 * Created by LS on 2017/11/2 8:16.
 * To Be or Not to Be
 */
public interface TrainService {
    void addTrain(Train train);

    List<Train> queryAllTrain();

    void deleteTrain(int id);

    void updateTrain(Train train);

    Train queryTrainById(int id);
}
