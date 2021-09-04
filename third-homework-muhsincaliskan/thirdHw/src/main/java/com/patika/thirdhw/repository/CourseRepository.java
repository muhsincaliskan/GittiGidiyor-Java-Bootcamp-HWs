package com.patika.thirdhw.repository;

import com.patika.thirdhw.entity.Course;
import com.patika.thirdhw.entity.Instructor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course>{
    Instructor findInstructorOfCourse(int id);
}
