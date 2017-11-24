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
    public static final String HASDELIVER="��Ͷ��";
    public static final String HASRED="�Ѳ鿴";
    public static final String SENDINVITATION="��������";
    public static final String NOTCONFIRM="δȷ��";
    public static final String WAITING="�ȴ�����";
    public static final String ADMISSION="¼ȡ";
    public static final String REFUSE="����������";
    public static final String FORMAL="��ʽ";
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
