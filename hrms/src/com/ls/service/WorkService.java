package com.ls.service;

import com.ls.model.Work;

/**
 * Created by LS on 2017/11/2 15:10.
 * To Be or Not to Be
 */
public interface WorkService {
    void saveWorkTime(Work work);
    Work queryWork();
}
