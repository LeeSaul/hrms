package com.ls.service.impl;

import com.ls.dao.DeliveryDao;
import com.ls.model.Delivery;
import com.ls.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LS on 2017/10/30 13:51.
 * To Be or Not to Be
 */
@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryDao deliveryDao;

    @Override
    public Delivery queryByReIdAndRecId(Delivery delivery) {
        return deliveryDao.queryByReIdAndRecId(delivery);
    }

    @Override
    public void saveDelivery(Delivery delivery) {
        deliveryDao.saveDelivery(delivery);
    }

    @Override
    public List<Delivery> queryAllDelivery() {
        return deliveryDao.queryAllDelivery();
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        deliveryDao.updateDelivery(delivery);
    }

    @Override
    public Delivery queryDelivery(int id) {
        return deliveryDao.queryDelivery(id);
    }

    @Override
    public List<Delivery> queryDeliveryByResumeId(int resumeId) {
        return deliveryDao.queryDeliveryByResumeId(resumeId);
    }

    @Override
    public List<Delivery> queryDepByStatus(String status) {
        return deliveryDao.queryDepByStatus(status);
    }
}
