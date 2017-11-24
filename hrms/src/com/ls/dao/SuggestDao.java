package com.ls.dao;

import com.ls.model.Suggest;

import java.util.List;

/**
 * Created by LS on 2017/11/8 9:09.
 * To Be or Not to Be
 */
public interface SuggestDao {
    void addSuggest(Suggest suggest);

    List<Suggest> querySuggest(int empId);

    List<Suggest> queryAllSuggest();

    void updateSuggest(Suggest suggest);
}
