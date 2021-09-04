package com.patika.thirdhw.service;

import com.patika.thirdhw.entity.Course;
import com.patika.thirdhw.entity.Instructor;
import com.patika.thirdhw.repository.InstructorRepository;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorService implements BaseService<Instructor> {
    InstructorRepository instructorRepository;

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
        return instructorRepository.save(object);
    }

    @Override
    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public Instructor update(Instructor object, int id) {
        return instructorRepository.updateOnDatabase(object,id);
    }


    public List<Course> findCoursesOfInstructor(int id) {
        return findById(id).getCourseList();
    }
}
