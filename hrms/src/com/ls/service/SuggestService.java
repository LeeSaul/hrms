package com.ls.service;

import com.ls.model.Suggest;

import java.util.List;

/**
 * Created by LS on 2017/11/8 9:07.
 * To Be or Not to Be
 */
public interface SuggestService {
    void addSuggest(Suggest suggest);

    List<Suggest> querySuggest(int empId);

    List<Suggest> queryAllSuggest();

    void agreeSuggest(int empId,int id, int salary);

    void refuseSuggest(int id);
}
