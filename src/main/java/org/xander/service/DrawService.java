package org.xander.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xander.dao.Dao;
import org.xander.dao.DrawHibernateDao;
import org.xander.model.Draw;

import java.util.List;

@Service(value = "drawService")
@Transactional
public class DrawService implements ContentService<Draw>{
    Dao dao;

    public DrawService(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Draw getById(Long id) {
        return (Draw) dao.get(id);
    }

    @Override
    public void addContent(Draw draw) {
        dao.saveOrUpdate(draw);
    }

    @Override
    public List<Draw> getAll() {
        return dao.getAll();
    }

    public List<Draw> getDrawByPrize(int prize) {
        return ((DrawHibernateDao) dao).getByPrize(prize);
    }
}
