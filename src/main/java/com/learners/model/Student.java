package com.learners.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private int student_id;

	@Column(name = "student_name")
	private String student_name;

	@Column(name = "class_id")
	private int class_id;

	@Column(name = "student_address")
	private String student_address;

	@Column(name = "student_mobile")
	private String student_mobile;

	public Student() {
		super();
	}

	public Student(String student_name, int class_id, String student_address, String student_mobile) {
		super();
		this.student_name = student_name;
		this.class_id = class_id;
		this.student_address = student_address;
		this.student_mobile = student_mobile;
	}

	public Student(int student_id, String student_name, int class_id, String student_address, String student_mobile) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.class_id = class_id;
		this.student_address = student_address;
		this.student_mobile = student_mobile;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_name(int class_id) {
		this.class_id = class_id;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public String getStudent_mobile() {
		return student_mobile;
	}

	public void setStudent_mobile(String student_mobile) {
		this.student_mobile = student_mobile;
	}
}
