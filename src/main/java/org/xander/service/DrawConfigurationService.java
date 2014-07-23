package org.xander.service;

import org.springframework.transaction.annotation.Transactional;
import org.xander.dao.Dao;
import org.xander.dao.DrawConfigurationHibernateDao;
import org.xander.model.DrawConfiguration;

import java.util.List;

@Transactional
public class DrawConfigurationService implements ContentService<DrawConfiguration> {
    Dao dao;

    public DrawConfigurationService(Dao dao) {
        this.dao = dao;
    }

    public DrawConfigurationService() {
    }

    @Override
    public DrawConfiguration getById(Long id) {
        return (DrawConfiguration) dao.get(id);
    }

    @Override
    public void addContent(DrawConfiguration drawConfiguration) {
        dao.saveOrUpdate(drawConfiguration);
    }

    @Override
    public List<DrawConfiguration> getAll() {
        return dao.getAll();
    }

    public List<DrawConfiguration> getDrawConfigurationByPrize(int prize) {
        return ((DrawConfigurationHibernateDao)dao).getByPrize(prize);
    }

    public void generateContent(DrawConfiguration drawConfiguration) {
        addContent(drawConfiguration);
    }
}
