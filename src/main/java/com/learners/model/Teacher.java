package com.learners.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "teacher_id")
	private int teacher_id;

	@Column(name = "teacher_name")
	private String teacher_name;

	@Column(name = "teacher_email")
	private String teacher_email;

	@Column(name = "teacher_class")
	private int teacher_class;

	public Teacher() {
		super();
	}

	public Teacher(String teacher_name, String teacher_email, int teacher_class) {
		super();
		this.teacher_name = teacher_name;
		this.teacher_email = teacher_email;
		this.teacher_class = teacher_class;
	}

	public Teacher(int teacher_id, String teacher_name, String teacher_email, int teacher_class) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.teacher_email = teacher_email;
		this.teacher_class = teacher_class;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_email() {
		return teacher_email;
	}

	public void setTeacher_email(String teacher_email) {
		this.teacher_email = teacher_email;
	}

	public int getTeacher_class() {
		return teacher_class;
	}

	public void setTeacher_class(int teacher_class) {
		this.teacher_class = teacher_class;
	}

}
