package com.ls.dao;

import com.ls.model.Train;

import java.util.List;

/**
 * Created by LS on 2017/11/2 8:17.
 * To Be or Not to Be
 */
public interface TrainDao {

    void addTrain(Train train);

    List<Train> queryAllTrain();

    void deleteTrain(int id);

    void updateTrain(Train train);

    Train queryTrainById(int id);
}
