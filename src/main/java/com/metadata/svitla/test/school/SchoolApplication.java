package com.metadata.svitla.test.school;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.metadata.svitla.test.school.entity.Course;
import com.metadata.svitla.test.school.entity.Student;
import com.metadata.svitla.test.school.repository.CourseRepository;
import com.metadata.svitla.test.school.repository.StudentRepository;

@SpringBootApplication
public class SchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner mappingDemo(StudentRepository studentRepository,
                                         CourseRepository courseRepository) {
        return args -> {

            // create a student
            Student student = new Student("David Zapata");

            // save the student
            studentRepository.save(student);

            // create three courses
            Course course1 = new Course("Machine Learning");
            Course course2 = new Course("Database Systems");
            Course course3 = new Course("Mathematics Basics");

            // save courses
            courseRepository.saveAll(Arrays.asList(course1, course2, course3));

            // add courses to the student
            student.getCourses().addAll(Arrays.asList(course1, course2, course3));

            // update the student
            studentRepository.save(student);
        };
    }

}
