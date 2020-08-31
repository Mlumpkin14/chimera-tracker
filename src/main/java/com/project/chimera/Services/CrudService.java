package com.project.chimera.Services;

import org.springframework.stereotype.Service;

import java.util.List;


public interface CrudService<T, ID> {

    List<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
