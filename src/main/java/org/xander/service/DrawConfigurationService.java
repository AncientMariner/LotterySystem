package org.xander.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xander.dao.Dao;
import org.xander.dao.DrawConfigurationHibernateDao;
import org.xander.model.DrawConfiguration;
import org.xander.model.Persistent;

import java.util.List;

@Service(value = "drawConfigurationService")
@Transactional
public class DrawConfigurationService implements ContentService<Persistent> {
    Dao dao;

    public DrawConfigurationService(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Persistent getById(Long id) {
        return dao.get(id);
    }

    @Override
    public void addContent(Persistent drawConfiguration) {
        dao.saveOrUpdate(drawConfiguration);
    }

    @Override
    public List<Persistent> getAll() {
        return dao.getAll();
    }

    public List<DrawConfiguration> getDrawConfigurationByPrize(int prize) {
        return ((DrawConfigurationHibernateDao)dao).getByPrize(prize);
    }

    public void generateContent(DrawConfiguration drawConfiguration) {
        addContent(drawConfiguration);
    }
}
