package com.example.demo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tbl {

	@Id
	private String id;

	private Date date;

	public Tbl() {
	}

	public Tbl(final String id, final Date date) {
		this.id = id;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	@Override public String toString() {
		return "Tbl{" +
				"id='" + id + '\'' +
				", date=" + date +
				'}';
	}
}
