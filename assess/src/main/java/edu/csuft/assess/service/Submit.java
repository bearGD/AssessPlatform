package edu.csuft.assess.service;

import java.util.List;

public class Submit {

	String teacherName;
	String className;
	int sumScore;
	List<Integer> itemId;

	public Submit() {
	}

	public Submit(String teacherName, String className, int sumScore, List<Integer> itemId) {
		super();
		this.teacherName = teacherName;
		this.className = className;
		this.sumScore = sumScore;
		this.itemId = itemId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getSumScore() {
		return sumScore;
	}

	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}

	public List<Integer> getItemId() {
		return itemId;
	}

	public void setItemId(List<Integer> itemId) {
		this.itemId = itemId;
	}

	
}
