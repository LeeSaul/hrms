package com.ls.model;

import java.io.Serializable;

/**
 * Created by LS on 2017/10/30 13:47.
 * To Be or Not to Be
 */
public class Delivery implements Serializable{
    private int id;
    private int resumeId;
    private int recId;
    private String status;
    private Resume resume;
    private Recruitment recruitment;
    public static final String HASDELIVER="已投递";
    public static final String HASRED="已查看";
    public static final String SENDINVITATION="邀请面试";
    public static final String NOTCONFIRM="未确定";
    public static final String WAITING="等待面试";
    public static final String ADMISSION="录取";
    public static final String REFUSE="不符合条件";
    public static final String FORMAL="正式";
    public Delivery() {
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", resumeId=" + resumeId +
                ", recId=" + recId +
                ", status='" + status + '\'' +
                ", resume=" + resume +
                ", recruitment=" + recruitment +
                '}';
    }
}
