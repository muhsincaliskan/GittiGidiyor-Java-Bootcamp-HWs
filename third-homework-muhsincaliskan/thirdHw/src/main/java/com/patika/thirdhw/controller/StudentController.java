package com.patika.thirdhw.controller;

import com.patika.thirdhw.entity.Student;
import com.patika.thirdhw.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){this.studentService=studentService;}
    @GetMapping("/instructors/{id}")
    public Student findStudent(@PathVariable int studentId){
        return studentService.findById(studentId);
    }
    @GetMapping("/students")
    public List<Student> findAllStudent(){
        return studentService.findAll();
    }
    @PostMapping("/students")
    public void saveStudent(Student student){
        studentService.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
    }
    @PutMapping("/students")
    public void updateStudent(Student student,@PathVariable int id){
        studentService.update(student, id);
    }

}
