package com.schoolmanagement.repository;

import com.schoolmanagement.models.Instructor;
import com.schoolmanagement.models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class StudentRepositoryJPAImpl implements CrudRepository<Student>{
    private EntityManager entityManager;
    private static final Logger logger = LoggerFactory.getLogger(StudentRepositoryJPAImpl.class);

    @Autowired
    public StudentRepositoryJPAImpl(EntityManager entityManager){this.entityManager=entityManager;}
    @Override
    public List findAll() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public Student saveToDatabase(Student object) {
        return entityManager.merge(object);
    }

    @Override
    public void deleteFromDatabase(int id) {
        Student student=this.findById(id);
        if (student==null){
            logger.error("There is no employee with id : " + id);
        }
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public Student updateOnDatabase(Student object, int id) {
        return entityManager.merge(object);
    }
}
