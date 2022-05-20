package com.metadata.svitla.test.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metadata.svitla.test.school.entity.Course;
import com.metadata.svitla.test.school.entity.Student;
import com.metadata.svitla.test.school.service.CourseService;
import com.metadata.svitla.test.school.service.StudentService;

@RestController
@RequestMapping("/school")
public class SchoolController {
  
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    

    @GetMapping("students")
    public ResponseEntity<List<Student>> listStudents(){
    	
    	List<Student> students = studentService.listStudent();
    	return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @GetMapping("courses")
    public ResponseEntity<List<Course>> listCourse(){
    	
    	List<Course> courses = courseService.listCourse();
    	return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }


}