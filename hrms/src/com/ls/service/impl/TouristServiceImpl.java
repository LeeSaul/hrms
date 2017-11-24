package com.ls.service.impl;

import com.ls.dao.TouristDao;
import com.ls.model.Resume;
import com.ls.model.Tourist;
import com.ls.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by LS on 2017/10/26 12:22.
 * To Be or Not to Be
 */
@Transactional
@Service
public class TouristServiceImpl implements TouristService{
    @Autowired
    private TouristDao touristDao;


    @Override
    public boolean queryTouristName(String tourName) {
        Tourist tourist = touristDao.queryTouristName(tourName);
        if (tourist!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean tourRegister(Tourist tourist) {
        return touristDao.tourRegister(tourist);
    }

    @Override
    public Tourist tourLogin(Tourist tourist) {
        return touristDao.tourLogin(tourist);
    }

}
