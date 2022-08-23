package com.learners.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="subject_id")
	private int subject_id;
	
	@Column(name="teacher_id")
	private int teacher_id;
	
	@Column(name="subject_name")
	private String subject_name;
	

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(int teacher_id, String subject_name) {
		super();
		this.teacher_id = teacher_id;
		this.subject_name = subject_name;
	}

	public Subject(int subject_id, int teacher_id, String subject_name) {
		super();
		this.subject_id = subject_id;
		this.teacher_id = teacher_id;
		this.subject_name = subject_name;
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}	

}
