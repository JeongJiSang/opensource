package com.jbground.source.database.repository.hibernate;

import com.jbground.source.database.dao.PersistentDao;
import com.jbground.source.database.model.Carrier;
import com.jbground.source.database.repository.CarrierRepository;

public class HibernateCarrierRepository implements CarrierRepository {

    private PersistentDao persistentDao;

    @Override
    public Carrier getCarrier(String carrierId) {
        return (Carrier) persistentDao.find(carrierId);
    }
}
