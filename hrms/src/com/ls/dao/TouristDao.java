package com.ls.dao;

import com.ls.model.Resume;
import com.ls.model.Tourist;
import org.springframework.stereotype.Repository;


/**
 * Created by LS on 2017/10/26 11:30.
 * To Be or Not to Be
 */
public interface TouristDao {
    Tourist queryTouristName(String tourName);

    boolean tourRegister(Tourist tourist);

    Tourist tourLogin(Tourist tourist);

    boolean addResume(Resume resume);
}
