package com.ls.service;

import com.ls.model.RewardsPunishment;

import java.util.List;

/**
 * Created by LS on 2017/11/2 15:09.
 * To Be or Not to Be
 */
public interface RewardsPunishmentService {
    List<RewardsPunishment> queryLastMonthPunishment(int empId, String startTime, String endTime);

    List<RewardsPunishment> queryRewardsPun();
}
