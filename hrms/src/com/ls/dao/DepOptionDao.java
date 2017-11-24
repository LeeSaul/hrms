package com.ls.dao;

import com.ls.model.DepOption;

import java.util.List;

/**
 * Created by LS on 2017/10/31 10:52.
 * To Be or Not to Be
 */
public interface DepOptionDao {
    void addOption(DepOption depOption);

    void updateOption(DepOption depOption);

    List<DepOption> queryOptionByDepId(int depId);

    void deleteOption(int id);

    void deleteOptionByDepId(int depId);

    DepOption queryOptionById(int id);
}
