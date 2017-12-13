package com.sxt.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	private Integer stuId;
	private String stuName;
	private String stuPwd;
	private Date stuDate;
	private String stuPhoto;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Integer stuId, String stuName, String stuPwd, Date stuDate) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuPwd = stuPwd;
		this.stuDate = stuDate;
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPwd() {
		return stuPwd;
	}

	public void setStuPwd(String stuPwd) {
		this.stuPwd = stuPwd;
	}

	public Date getStuDate() {
		return stuDate;
	}

	public void setStuDate(Date stuDate) {
		this.stuDate = stuDate;
	}

	public String getStuPhoto() {
		return stuPhoto;
	}

	public void setStuPhoto(String stuPhoto) {
		this.stuPhoto = stuPhoto;
	}

}
