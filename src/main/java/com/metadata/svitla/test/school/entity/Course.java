package com.metadata.svitla.test.school.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "course")
public class Course implements Serializable {
    
	private static final long serialVersionUID = -7601830401815207018L;
	
	//PK of table, Auto-numeric id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCourse;
    private String name;
    
    @ManyToMany(mappedBy = "school",  fetch = FetchType.LAZY)    
    Set<Student> students = new HashSet<>();

    public Course() {
    }
    
    public Course(String name) {
    	this.name= name;
    }

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}