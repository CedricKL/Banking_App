package com.formation.banking.services;

import java.util.List;

// This class is a generic for all our services it's a way to reduce code writing
public interface AbstractServices<T> {

    Integer save(T dto);  // This method will be used to create or modify an object

    List<T> findAll();

    T findById(Integer id);

    void delete(Integer id);
}
