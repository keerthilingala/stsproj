package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback_table")
public class Feedbackquestions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int customerId;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Column
	private String saname;
	@Column
	private String ans1;
	@Column
	private String ans2;
	@Column
	private String ans3;
	@Column
	private String ans4;
	@Column
	private String ans5;
	@Column
	private String description;
	
	
	public String getSaname() {
		return saname;
	}
	public void setSaname(String saname) {
		this.saname = saname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}
	public String getAns4() {
		return ans4;
	}
	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}
	public String getAns5() {
		return ans5;
	}
	public void setAns5(String ans5) {
		this.ans5 = ans5;
	}
	@Override
	public String toString() {
		return "Feedbackquestions [customerId=" + customerId + ", saname=" + saname + ", ans1=" + ans1 + ", ans2="
				+ ans2 + ", ans3=" + ans3 + ", ans4=" + ans4 + ", ans5=" + ans5 + ", description=" + description + "]";
	}
	

}
