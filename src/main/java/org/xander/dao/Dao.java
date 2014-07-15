package org.xander.dao;

import org.xander.model.Persistent;

import java.util.List;

public interface Dao<T extends Persistent> {
    void saveOrUpdate(T content);
    T get(Long id);
    List<T> getAll();
//    List<T> getByPrize(int prize);
}
