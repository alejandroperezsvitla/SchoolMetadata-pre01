package com.metadata.svitla.test.school.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metadata.svitla.test.school.entity.Course;
import com.metadata.svitla.test.school.entity.Student;
import com.metadata.svitla.test.school.repository.CourseRepository;
import com.metadata.svitla.test.school.repository.StudentRepository;

@Service
@Transactional
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;
        

    public List<Course> listCourse(){
    	List<Course> listCourse = new ArrayList<>();
    	courseRepository.findAll().forEach(listCourse::add);
    	return listCourse;
    }
    
    public List<Course> listEmpty(){
    	List<Course> listEmpty = new ArrayList<>();
    	
    	for (Course course : listEmpty()) {
			if(course.getStudents().size() == 0) {
				listEmpty.add(course);
			}
				
		}
    	return listEmpty;
    }

    public Course getCourse(int idcourse){
       return  courseRepository.findCourseById(idcourse);
    }

    public void saveCourse(Course course){
        courseRepository.save(course);
    }

    public void deleteCourse(int idcourse){
        courseRepository.deleteById(idcourse);
    }
    
    
	public void addStudent(int idCourse, int idStudent) {
		Course course = getCourse(idCourse);
		Student student = studentRepository.findStudentById(idStudent);
		
		Set<Course> courses = student.getCourses();
		if (courses.size()>=50) {
			System.out.println("Could not add more");
			return;
		}
		courses.add(course);
	}
	
	public boolean removeCourse (int idCourse, int idStudent) {
		Course course = courseRepository.findCourseById(idCourse);
		Student student = studentRepository.findStudentById(idStudent);
		
		return student.getCourses().remove(course);
	}
}