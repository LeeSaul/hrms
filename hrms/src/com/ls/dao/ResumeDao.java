package com.ls.dao;

import com.ls.model.Resume;

import java.util.List;

/**
 * Created by LS on 2017/10/26 16:52.
 * To Be or Not to Be
 */
public interface ResumeDao {

    boolean addResume(Resume resume);

    Resume queryResume(int tourId);

    Resume queryDetailResume(int id);

    void updateResume(Resume resume);

    void updateEmpResume(Resume resume);
}
