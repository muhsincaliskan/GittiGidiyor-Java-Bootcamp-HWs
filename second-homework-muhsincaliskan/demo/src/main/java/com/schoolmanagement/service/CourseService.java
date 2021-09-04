package com.schoolmanagement.service;

import com.schoolmanagement.models.Course;
import com.schoolmanagement.models.Instructor;
import com.schoolmanagement.repository.CourseRepository;
import com.schoolmanagement.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.EntityManagerHolder;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CourseService implements BaseService<Course> {
    private CourseRepository courseRepository;
    public CourseService(@Qualifier("CourseRepositoryRepositoryJPAImpl")CourseRepository courseRepository ){this.courseRepository=courseRepository;}
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course object) {
        return (Course) courseRepository.saveToDatabase(object);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteCourseFromDatabase(id);
    }

    @Override
    public Course update(Course object,int id) {
        return (Course) courseRepository.updateOnDatabase(object,id);
    }
    public Instructor findInstructorOfCourse(int id) {

        return findById(id).getInstructor();

    }

}
