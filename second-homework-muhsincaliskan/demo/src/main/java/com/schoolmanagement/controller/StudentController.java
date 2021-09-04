package com.schoolmanagement.controller;

import com.schoolmanagement.models.Student;
import com.schoolmanagement.service.CourseService;
import com.schoolmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
