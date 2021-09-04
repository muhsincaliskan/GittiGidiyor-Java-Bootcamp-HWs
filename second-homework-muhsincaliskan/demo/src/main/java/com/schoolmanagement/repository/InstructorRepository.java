package com.schoolmanagement.repository;

import com.schoolmanagement.models.Course;
import com.schoolmanagement.models.Instructor;

import java.util.List;

public interface InstructorRepository extends CrudRepository<Instructor>{
    void deleteInstructorFromDatabase(int id);
    List<Course> findCoursesOfInstructor(int id);
}
