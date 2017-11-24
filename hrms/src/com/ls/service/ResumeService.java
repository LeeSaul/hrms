package com.ls.service;

import com.ls.model.Resume;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

/**
 * Created by LS on 2017/10/26 16:56.
 * To Be or Not to Be
 */
public interface ResumeService {
    boolean addResume(Resume resume);

    Resume queryResume(int tourId);
    Resume queryDetailResume(int id);

    void updateResume(Resume resume);

    void updateEmpResume(Resume resume);
}
