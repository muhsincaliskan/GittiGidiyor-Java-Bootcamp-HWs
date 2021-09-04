package com.patika.thirdhw.util;

import com.patika.thirdhw.entity.*;
import com.patika.thirdhw.repository.CrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InitializerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);
    private static CrudRepository<Student> studentRepository;
    private static CrudRepository<Instructor> instructorRepository;
    private static CrudRepository<Course> courseRepository;


    public void run(String... args) throws Exception  {
        studentRepository.deleteAll();
        instructorRepository.deleteAll();
        courseRepository.deleteAll();
        Student student1 = Student.builder().name("Muhsin").address("Ankara").gender("Male").birthDate(new Date(1996, 8, 9)).id(1).build();
        Student student2 = Student.builder().name("Volkan").address("Ankara").gender("Male").birthDate(new Date(1995, 8, 9)).id(2).build();
        Student student3 = Student.builder().name("Arda").address("Eskişehir").gender("Male").birthDate(new Date(1998, 8, 9)).id(3).build();
        Student student4 = Student.builder().name("Melike").address("İstanbul").gender("Female").birthDate(new Date(1996, 8, 9)).id(4).build();
        Student student5 = Student.builder().name("Selin").address("Kayseri").gender("Female").birthDate(new Date(1996, 8, 9)).id(5).build();

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);

        PermanentInstructor instructor1= PermanentInstructor.builder().name("Hoca1").address("Ankara").phoneNumber(123456767).fixedSalary(4000).build();
        VisitingResearches instructor2= VisitingResearches.builder().name("Hoca2").address("İstanbul").phoneNumber(13566577).hourlySalary(12345).build();
        Instructor instructor3=Instructor.builder().name("Hoca3").phoneNumber(123456789).address("İzmir").build();
        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);

        Course course1= Course.builder().courseName("Java").courseCode("1232").creditScore(20).build();
        Course course2=Course.builder().courseName("JavaScript").courseCode("1235").creditScore(30).build();
        Course course3= Course.builder().courseName("SQL").courseCode("1231").creditScore(23).build();

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor3);

        course1.getStudentList().add(student1);
        course1.getStudentList().add(student2);
        course1.getStudentList().add(student3);

        course2.getStudentList().add(student2);
        course2.getStudentList().add(student3);
        course2.getStudentList().add(student4);

        course3.getStudentList().add(student1);
        course3.getStudentList().add(student3);
        course3.getStudentList().add(student5);
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        studentRepository.findAll().forEach(student -> logger.info("{}", student));
        courseRepository.findAll().forEach(course -> logger.info("{}", course));
        instructorRepository.findAll().forEach(instructor -> logger.info("{}",instructor));
    }
}
