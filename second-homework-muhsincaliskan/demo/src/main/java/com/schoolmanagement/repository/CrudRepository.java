package com.schoolmanagement.repository;


import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CrudRepository<T> {

    List<T> findAll();
    T findById(int id);
    T saveToDatabase(T object);
    void deleteFromDatabase(int id);
    T updateOnDatabase(T object, int id);

}