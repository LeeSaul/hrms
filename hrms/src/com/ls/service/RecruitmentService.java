package com.ls.service;

import com.ls.model.Recruitment;
import com.ls.model.Resume;

import java.util.List;

/**
 * Created by LS on 2017/10/27 14:54.
 * To Be or Not to Be
 */
public interface RecruitmentService {

    boolean addRecruitment(Recruitment recruitment);

    List<Recruitment> queryRecruitment();

    Recruitment queryRecruitmentById(int id);

    void updateRecruitment(Recruitment recruitment);

    List<Resume> queryResume(int id);

    void deleteRecruitmentById(int id);
}
