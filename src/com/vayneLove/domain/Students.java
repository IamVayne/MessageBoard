package com.vayneLove.domain;

/**
 * Students entity. @author MyEclipse Persistence Tools
 */

public class Students implements java.io.Serializable {

	// Fields

	private String stuid;
	private String stuname;
	private Short score;

	// Constructors

	/** default constructor */
	public Students() {
	}

	/** minimal constructor */
	public Students(String stuid, String stuname) {
		this.stuid = stuid;
		this.stuname = stuname;
	}

	/** full constructor */
	public Students(String stuid, String stuname, Short score) {
		this.stuid = stuid;
		this.stuname = stuname;
		this.score = score;
	}

	// Property accessors

	public String getStuid() {
		return this.stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getStuname() {
		return this.stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public Short getScore() {
		return this.score;
	}

	public void setScore(Short score) {
		this.score = score;
	}

}