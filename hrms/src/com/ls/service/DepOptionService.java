package com.ls.service;

import com.ls.model.DepOption;

import java.util.List;

/**
 * Created by LS on 2017/10/31 10:51.
 * To Be or Not to Be
 */
public interface DepOptionService {
    void addOption(DepOption depOption);

    void updateOption(DepOption depOption);

    List<DepOption> queryOptionByDepId(int depId);

    void deleteOption(int id);

    void deleteOptionByDepId(int depId);

    DepOption queryOptionById(int id);
}
