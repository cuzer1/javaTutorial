package com.cengiz.examples;

public class Record {

	private Long Id;
	private String name;
	private String email;
	private String date;
	
	public Record(Long id, String name, String email, String date) {
		this.Id = id;
		this.name = name;
		this.email = email;
		this.date = date;
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Record [Id=" + Id + ", name=" + name + ", email=" + email + ", date=" + date + "]";
	}
	
	

}
