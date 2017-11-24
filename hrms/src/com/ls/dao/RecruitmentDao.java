package com.ls.dao;

import com.ls.model.Recruitment;

import java.util.List;

/**
 * Created by LS on 2017/10/27 14:55.
 * To Be or Not to Be
 */
public interface RecruitmentDao {
    boolean addRecruitment(Recruitment recruitment);

    List<Recruitment> queryRecruitment();

    Recruitment queryRecruitmentById(int id);

    void updateRecruitment(Recruitment recruitment);

    void deleteRecruitmentById(int id);
}
