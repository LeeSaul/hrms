package com.ls.service;

import com.ls.model.Delivery;

import java.util.List;

/**
 * Created by LS on 2017/10/30 13:51.
 * To Be or Not to Be
 */
public interface DeliveryService {
    Delivery queryByReIdAndRecId(Delivery delivery);

    void saveDelivery(Delivery delivery);

    List<Delivery> queryAllDelivery();

    void updateDelivery(Delivery delivery);

    Delivery queryDelivery(int id);

    List<Delivery> queryDeliveryByResumeId(int resumeId);

    List<Delivery> queryDepByStatus(String status);
}
