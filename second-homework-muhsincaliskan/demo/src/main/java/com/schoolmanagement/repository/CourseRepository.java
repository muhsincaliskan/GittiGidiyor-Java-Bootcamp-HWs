package com.schoolmanagement.repository;

import com.schoolmanagement.models.Course;
import com.schoolmanagement.models.Instructor;


public interface CourseRepository extends CrudRepository<Course> {
    void deleteCourseFromDatabase(int id);
    Instructor findInstructorOfCourse(int id);
}
