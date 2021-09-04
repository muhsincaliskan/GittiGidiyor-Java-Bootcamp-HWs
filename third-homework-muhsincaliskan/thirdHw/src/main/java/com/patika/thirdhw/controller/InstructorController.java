package com.patika.thirdhw.controller;

import com.patika.thirdhw.entity.Instructor;
import com.patika.thirdhw.service.InstructorService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequiredArgsConstructor
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
