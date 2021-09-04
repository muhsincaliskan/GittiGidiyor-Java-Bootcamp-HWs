package com.schoolmanagement.controller;

import com.schoolmanagement.models.Instructor;
import com.schoolmanagement.service.CourseService;
import com.schoolmanagement.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class InstructorController {
    private InstructorService instructorService;
    @Autowired
    public InstructorController(InstructorService instructorService){this.instructorService=instructorService;}
    @GetMapping("/instructors/{id}")
    public Instructor findInstructor(@PathVariable int instructorId){
        return instructorService.findById(instructorId);
    }
    @GetMapping("/instructors")
    public List<Instructor> findAll(){
        return instructorService.findAll();
    }
    @PostMapping("/instructors")
    public void save(Instructor instructor){
        instructorService.save(instructor);
    }

    @DeleteMapping("/instructors/{id}")
    public void delete(@PathVariable int id){
        instructorService.deleteById(id);
    }
    @PutMapping("/instructors/{id}")
    public void update(Instructor instructor,@PathVariable int id){
        instructorService.update(instructor, id);
    }

}
