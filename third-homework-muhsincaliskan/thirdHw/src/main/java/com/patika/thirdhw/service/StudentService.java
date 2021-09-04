package com.patika.thirdhw.service;

import com.patika.thirdhw.entity.Course;
import com.patika.thirdhw.entity.Student;
import com.patika.thirdhw.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements BaseService<Student> {
    private StudentRepository studentRepository;

    @Override
    public List findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return  studentRepository.findById(id);
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student update(Student object, int id) {
        return studentRepository.updateOnDatabase(object,id);
    }

    public List<Course> findCoursesOfStudent(int id) {
        return findById(id).getCourseList();
    }
}
