package com.metadata.svitla.test.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.metadata.svitla.test.school.entity.Course;
import com.metadata.svitla.test.school.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	Student findStudentById(Integer id);

	List<Course> getCoursesByStudent(Integer studentId);
	
	List<Course> findEmpty();

}