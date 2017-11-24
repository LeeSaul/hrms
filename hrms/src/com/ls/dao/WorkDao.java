package com.ls.dao;

import com.ls.model.Work;

/**
 * Created by LS on 2017/11/2 15:10.
 * To Be or Not to Be
 */
public interface WorkDao {
    void saveWordTime(Work work);

    Work queryWork();

    void updateWork(Work work);
}
