package com.learners.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="classes")
public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="class_id")
	private int class_id;
	
	@Column(name="class_name")
	private String class_name;	

	public Classes() {
		super();
	}
	
	public Classes(String class_name) {
		super();
		this.class_name = class_name;
	}

	public Classes(int class_id, String class_name) {
		super();
		this.class_id = class_id;
		this.class_name = class_name;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	

	
}
