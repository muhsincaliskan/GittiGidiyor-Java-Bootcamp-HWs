package com.schoolmanagement.repository;

import com.schoolmanagement.models.Course;
import com.schoolmanagement.models.Instructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class InstructorRepositoryJPAImpl implements CrudRepository<Instructor>{
    private static final Logger logger = LoggerFactory.getLogger(InstructorRepositoryJPAImpl.class);

    private EntityManager entityManager;
    @Autowired
    public InstructorRepositoryJPAImpl(EntityManager entityManager){this.entityManager=entityManager;}
    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("from Instructor", Instructor.class).getResultList();

    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public Instructor saveToDatabase(Instructor object) {
        return entityManager.merge(object);
    }

    @Override
    public void deleteFromDatabase(int id) {
        Instructor instructor=this.findById(id);
        if (instructor==null){
            logger.error("There is no employee with id : " + id);
        }
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public Instructor updateOnDatabase(Instructor object, int id) {
        return entityManager.merge(object);
    }
}
