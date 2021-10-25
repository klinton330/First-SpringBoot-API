package com.hari;

public class StudentInfo {
	String sname;
	int age;
	String course;
	String mobile;
	String city;
	int id;
	String errorMessage;
	
	
	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	@Override
	public String toString() {
		return "StudentInfo [name=" + sname + ", age=" + age + ", course=" + course + ", MobileNo=" + mobile
				+ ", city=" + city + ", id=" + id + ", errorMessage=" + errorMessage + "]";
	}
	
}
