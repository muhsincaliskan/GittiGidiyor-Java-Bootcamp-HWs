package com.patika.thirdhw.repository;


import com.patika.thirdhw.entity.Course;
import com.patika.thirdhw.entity.Instructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InstructorRepository extends CrudRepository<Instructor>{

    List<Course> findCoursesOfInstructor(int id);
}
