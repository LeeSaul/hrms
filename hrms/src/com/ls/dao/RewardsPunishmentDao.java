package com.ls.dao;

import com.ls.model.RewardsPunishment;

import java.util.List;

/**
 * Created by LS on 2017/11/2 15:09.
 * To Be or Not to Be
 */
public interface RewardsPunishmentDao {
    RewardsPunishment queryByAttId(int attId);
    void saveRewardsPunishment(RewardsPunishment rewardsPunishment);
//    RewardsPunishment queryByCreateTime(String startTime,String endTime,int empId);
    void deleteRewardsPunishment(String startTime,String endTime);

    List<RewardsPunishment> queryLastMonthPunishment(int empId, String startTime, String endTime);

    List<RewardsPunishment> queryPunishment(String last, String current);
}
