package com.schoolmanagement.service;

import com.schoolmanagement.models.Course;
import com.schoolmanagement.models.Instructor;
import com.schoolmanagement.repository.CourseRepository;
import com.schoolmanagement.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorService implements BaseService<Instructor> {
    InstructorRepository instructorRepository;
    public InstructorService(@Qualifier("InstructorRepositoryJPAImpl") InstructorRepository instructorRepository ){this.instructorRepository=instructorRepository;}

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();

    }

    @Override
    public Instructor findById(int id) {
        return instructorRepository.findById(id);

    }

    @Override
    public Instructor save(Instructor object) {
        return instructorRepository.saveToDatabase(object);
    }

    @Override
    public void deleteById(int id) {
        instructorRepository.deleteFromDatabase(id);
    }

    @Override
    public Instructor update(Instructor object, int id) {
        return instructorRepository.updateOnDatabase(object,id);
    }


    public List<Course> findCoursesOfInstructor(int id) {
        return findById(id).getCourseList();
    }
}
