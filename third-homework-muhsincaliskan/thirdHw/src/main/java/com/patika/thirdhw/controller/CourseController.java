package com.patika.thirdhw.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.patika.thirdhw.entity.Course;
import com.patika.thirdhw.entity.Instructor;
import com.patika.thirdhw.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class CourseController {

    private CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService){this.courseService=courseService;}

    @GetMapping("/coursed/{id}")
    public Course findCourse(int courseId){
        return courseService.findById(courseId);
    }
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAllCourse(){

        return new ResponseEntity<>( courseService.findAll(), HttpStatus.OK);
    }
    @PostMapping("courses")
    public Course saveCourse(@RequestBody Course course){
        return courseService.save(course);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id){
        courseService.deleteById(id);
        return "Deleted...";
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse(@RequestBody Course course,int id){
        return courseService.update(course,id);

    }
    @JsonProperty("instructor")
    @GetMapping("/courses/{id}")
    public Instructor getInstructor(@RequestBody int id){

        return courseService.findInstructorOfCourse(id);

    }
}
