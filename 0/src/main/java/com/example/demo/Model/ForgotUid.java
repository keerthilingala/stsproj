package com.example.demo.Model;

public class ForgotUid {
	private String uid;
	private String pwd;
	private String pwd1;
	private String qstn1;
	private String ans1;
	private String qstn2;
	private String ans2;
	
	private String phno;
	
	public String getPwd1() {
		return pwd1;
	}
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getQstn1() {
		return qstn1;
	}
	public void setQstn1(String qstn1) {
		this.qstn1 = qstn1;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getQstn2() {
		return qstn2;
	}
	public void setQstn2(String qstn2) {
		this.qstn2 = qstn2;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "ForgotUid [uid=" + uid + ", pwd=" + pwd + ", pwd1=" + pwd1 + ", qstn1=" + qstn1 + ", ans1=" + ans1
				+ ", qstn2=" + qstn2 + ", ans2=" + ans2 + ", phno=" + phno + "]";
	}
	


}
