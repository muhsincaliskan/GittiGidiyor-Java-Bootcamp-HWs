package com.schoolmanagement.repository;



import com.schoolmanagement.models.Course;
import com.schoolmanagement.models.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student>{
    void deleteStudentFromDatabase(int id);
    List<Course> findCoursesOfStudent(int id);
}
