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
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    public List<Student> listStudent(){
    	List<Student> listStudent = new ArrayList<>();
    	studentRepository.findAll().forEach(listStudent::add);
    	return listStudent;
    }
    
    public List<Student> listEmpty(){
    	List<Student> listEmpty = new ArrayList<>();
    	
    	for (Student student : listStudent()) {
			if(student.getCourses().size() == 0) {
				listEmpty.add(student);
			}
				
		}
    	return listEmpty;
    }

    public Student getStudent(int idstudent){
        return  studentRepository.findStudentById(idstudent);
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(int idstudent){
        studentRepository.deleteById(idstudent);
    }
    
	public void addCourse(int idStudent, int idCourse) {
		Course course = courseRepository.findCourseById(idCourse);
		Student student = getStudent(idStudent);
		
		
		Set<Course> courses = student.getCourses();
		if (courses.size()>=5) {
			System.out.println("Could not add more");
			return;
		}
		courses.add(course);
	}
	
	public boolean removeCourse (int idStudent, int idCourse) {
		Course course = courseRepository.findCourseById(idCourse);
		Student student = studentRepository.findStudentById(idStudent);
		
		return student.getCourses().remove(course);
	}


}