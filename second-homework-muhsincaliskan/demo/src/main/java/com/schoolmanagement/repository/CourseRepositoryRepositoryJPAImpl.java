package com.schoolmanagement.repository;

import com.schoolmanagement.models.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CourseRepositoryRepositoryJPAImpl implements CrudRepository<Course> {
    private static final Logger logger = LoggerFactory.getLogger(CourseRepositoryRepositoryJPAImpl.class);
    private EntityManager entityManager;
    @Autowired
    public CourseRepositoryRepositoryJPAImpl(EntityManager entityManager){this.entityManager=entityManager;}


    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public Course saveToDatabase(Course object) {
        return entityManager.merge(object);
    }

    @Override
    public void deleteFromDatabase(int id) {
        Course course=this.findById(id);
        if (course==null){
            logger.error("There is no employee with id : " + id);
        }
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public Course updateOnDatabase(Course object, int id) {

        return entityManager.merge(object);
    }
}
