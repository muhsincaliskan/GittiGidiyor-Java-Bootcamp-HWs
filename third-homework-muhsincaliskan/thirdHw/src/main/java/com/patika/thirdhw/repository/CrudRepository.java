package com.patika.thirdhw.repository;

import com.patika.thirdhw.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CrudRepository<T> {

    List<T> findAll();
    T findById(int id);
    T save(T object);
    void delete(T object);
    void deleteById(int id);
    T updateOnDatabase(T object, int id);
    void deleteAll();
}