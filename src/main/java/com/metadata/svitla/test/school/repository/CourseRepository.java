package com.metadata.svitla.test.school.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.metadata.svitla.test.school.entity.Course;
import com.metadata.svitla.test.school.entity.Student;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	Course findCourseById(Integer id);

	List<Student> getStudentsByCourse (Integer courseId);

	List<Course> findEmpty();

}