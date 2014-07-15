package org.xander.service;

import org.xander.model.Persistent;

import java.util.List;

public interface ContentService<T extends Persistent> {
    T getById(Long id);
    void addContent(T content);
    List<T> getAll();
}
