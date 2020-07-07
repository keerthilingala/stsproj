package com.example.demo.Model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@Generated("assigned")
	@Column
	private String adminId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String age; 
	@Column
	private String gender; 
	@Column
	private String contactNumber; 
	@Column
	private String password;
	@Column
	private String Conformpassword;
	@Column
	private String secretquestion1;
	@Column
	private String answer1;
	@Column
	private String secretquestion2;
	@Column
	private String answer2;
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConformpassword() {
		return Conformpassword;
	}
	public void setConformpassword(String conformpassword) {
		Conformpassword = conformpassword;
	}
	public String getSecretquestion1() {
		return secretquestion1;
	}
	public void setSecretquestion1(String secretquestion1) {
		this.secretquestion1 = secretquestion1;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getSecretquestion2() {
		return secretquestion2;
	}
	public void setSecretquestion2(String secretquestion2) {
		this.secretquestion2 = secretquestion2;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", password=" + password
				+ ", Conformpassword=" + Conformpassword + ", secretquestion1=" + secretquestion1 + ", answer1="
				+ answer1 + ", secretquestion2=" + secretquestion2 + ", answer2=" + answer2 + "]";
	}
	
	
	
	
	
}