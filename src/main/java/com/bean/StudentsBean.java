package com.bean;

public class StudentsBean {
	private int student_id;
	private String first_name = null;
	private String last_name = null;
	private String email = null;
	private String phone = null;
	private String dob = null;
	private String gender = null;
	private String address = null;
	private String course = null;
	private String batch_time = null;
	private String payment_mode = null;
	private boolean sports = false;
	private boolean music = false;
	private boolean debate = false;
	private boolean volunteering = false;
	public StudentsBean(int student_id, String first_name, String last_name, String email, String phone, String dob,
			String gender, String address, String course, String batch_time, String payment_mode, boolean sports,
			boolean music, boolean debate, boolean volunteering) {
		super();
		this.student_id = student_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.course = course;
		this.batch_time = batch_time;
		this.payment_mode = payment_mode;
		this.sports = sports;
		this.music = music;
		this.debate = debate;
		this.volunteering = volunteering;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getBatch_time() {
		return batch_time;
	}
	public void setBatch_time(String batch_time) {
		this.batch_time = batch_time;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public boolean isSports() {
		return sports;
	}
	public void setSports(boolean sports) {
		this.sports = sports;
	}
	public boolean isMusic() {
		return music;
	}
	public void setMusic(boolean music) {
		this.music = music;
	}
	public boolean isDebate() {
		return debate;
	}
	public void setDebate(boolean debate) {
		this.debate = debate;
	}
	public boolean isVolunteering() {
		return volunteering;
	}
	public void setVolunteering(boolean volunteering) {
		this.volunteering = volunteering;
	}
	
	
	
	
		
}
