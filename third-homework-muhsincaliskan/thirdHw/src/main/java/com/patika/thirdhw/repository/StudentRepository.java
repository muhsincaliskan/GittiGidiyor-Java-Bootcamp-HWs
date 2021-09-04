package com.patika.thirdhw.repository;

import com.patika.thirdhw.entity.Course;
import com.patika.thirdhw.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends CrudRepository<Student>{
    void deleteStudentFromDatabase(int id);
    List<Course> findCoursesOfStudent(int id);
}
