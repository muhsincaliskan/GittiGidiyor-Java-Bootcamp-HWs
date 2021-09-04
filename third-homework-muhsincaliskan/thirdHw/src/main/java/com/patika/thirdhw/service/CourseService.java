package com.patika.thirdhw.service;

import com.patika.thirdhw.entity.Course;
import com.patika.thirdhw.entity.Instructor;
import com.patika.thirdhw.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
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
        return courseRepository.save(object);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course update(Course object,int id) {
        return courseRepository.updateOnDatabase(object,id);
    }
    public Instructor findInstructorOfCourse(int id) {

        return findById(id).getInstructor();

    }

}
