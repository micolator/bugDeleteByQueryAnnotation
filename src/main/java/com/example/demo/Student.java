package com.example.demo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private String id;

	private String firstName;

	private Date date;

	public Student() {
	}

	public Student(final String id, final String firstName, final Date date) {
		this.id = id;
		this.firstName = firstName;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public Date getDate() {
		return date;
	}

	@Override public String toString() {
		return "Student{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", date=" + date +
				'}';
	}
}
