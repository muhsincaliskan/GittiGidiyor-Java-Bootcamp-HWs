package com.schoolmanagement.service;

import com.schoolmanagement.models.Course;
import com.schoolmanagement.models.Student;
import com.schoolmanagement.repository.CourseRepository;
import com.schoolmanagement.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements BaseService<Student> {
    private StudentRepository studentRepository;
    public StudentService(@Qualifier("StudentRepositoryRepositoryJPAImpl")StudentRepository studentRepository ){this.studentRepository=studentRepository;}
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
        return studentRepository.saveToDatabase(object);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteFromDatabase(id);
    }

    @Override
    public Student update(Student object, int id) {
        return studentRepository.updateOnDatabase(object,id);
    }

    public List<Course> findCoursesOfStudent(int id) {
        return findById(id).getCourseList();
    }
}
