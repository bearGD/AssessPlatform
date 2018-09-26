package edu.csuft.assess.service;

public class Item {

	int sub_id;
	String content;
	int score;
	String time;
	
	public Item() {
	}

	public Item(int sub_id, String content, int score, String time) {
		super();
		this.sub_id = sub_id;
		this.content = content;
		this.score = score;
		this.time = time;
	}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
