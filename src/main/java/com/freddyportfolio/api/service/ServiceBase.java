package com.freddyportfolio.api.service;

import java.util.List;

public interface ServiceBase<T> {
    Boolean save(Long id, T object);
    Boolean remove(Long id, Long objectId);
    List<T> findAll();
    T findById(Long id);
}
