package com.ls.service;


import com.ls.model.Resume;
import com.ls.model.Tourist;

/**
 * Created by LS on 2017/10/26 11:30.
 * To Be or Not to Be
 */
public interface TouristService {
    boolean queryTouristName(String tourName);

    boolean tourRegister(Tourist tourist);

    Tourist tourLogin(Tourist tourist);
}
