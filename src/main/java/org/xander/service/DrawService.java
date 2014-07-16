package org.xander.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xander.dao.Dao;
import org.xander.dao.DrawHibernateDao;
import org.xander.model.Draw;
import org.xander.model.Persistent;

import java.util.List;

@Service(value = "drawService")
@Transactional
public class DrawService implements ContentService<Persistent>{
    Dao dao;

    public DrawService(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Persistent getById(Long id) {
        return dao.get(id);
    }

    @Override
    public void addContent(Persistent draw) {
        dao.saveOrUpdate(draw);
    }

    @Override
    public List<Persistent> getAll() {
        return dao.getAll();
    }

    public List<Draw> getDrawByPrize(int prize) {
        return ((DrawHibernateDao) dao).getByPrize(prize);
    }
}
