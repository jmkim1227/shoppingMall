package com.care.root.membervo;

import java.util.Date;

public class MemberVO {
	   @Override
	public String toString() {
		return "MemberVO [Id=" + Id + ", Pwd=" + Pwd + ", Name=" + Name + ", Tel=" + Tel + ", Birth=" + Birth
				+ ", Mile=" + Mile + ", Email=" + Email + ", JoinDate=" + JoinDate + ", Address=" + Address + "]";
	}
	private String Id;
	   private String Pwd;
	   private String Name;
	   private String Tel;
	   private String Birth;
	   private int Mile;
	   private String Email;
	   private Date JoinDate;
	   private String Address;
	   public String getId() {
	      return Id;
	   }
	   public void setId(String id) {
	      Id = id;
	   }
	   public String getPwd() {
	      return Pwd;
	   }
	   public void setPwd(String pwd) {
	      Pwd = pwd;
	   }
	   public String getName() {
	      return Name;
	   }
	   public void setName(String name) {
	      Name = name;
	   }
	   public String getTel() {
	      return Tel;
	   }
	   
	   public void setTel(String tel) {
	      Tel = tel;
	   }
	   public String getBirth() {
	      return Birth;
	   }
	   public void setBirth(String birth) {
	      Birth = birth;
	   }
	   public int getMile() {
	      return Mile;
	   }
	   public void setMile(int mile) {
	      Mile = mile;
	   }
	   public String getEmail() {
	      return Email;
	   }
	   public void setEmail(String email) {
	      Email = email;
	   }
	   public Date getJoinDate() {
	      return JoinDate;
	   }
	   public void setJoinDate(Date joinDate) {
	      JoinDate = joinDate;
	   }
	   public String getAddress() {
	      return Address;
	   }
	   public void setAddress(String address) {
	      Address = address;
	   }


	      
	}