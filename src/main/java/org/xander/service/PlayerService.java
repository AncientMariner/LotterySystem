package org.xander.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xander.dao.Dao;
import org.xander.model.Persistent;

import java.util.List;

@Service(value = "plyerService")
@Transactional
public class PlayerService implements ContentService<Persistent> {
    Dao dao;

    public PlayerService(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Persistent getById(Long id) {
        return dao.get(id);
    }

    @Override
    public void addContent(Persistent player) {
        dao.saveOrUpdate(player);
    }

    @Override
    public List<Persistent> getAll() {
        return dao.getAll();
    }
}
