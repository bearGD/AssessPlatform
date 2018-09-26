package edu.csuft.assess.service;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	int id;
	String content;

	List<Item> items = new ArrayList<>();

	public Subject() {
	}

	public Subject(int id, String content, List<Item> items) {
		super();
		this.id = id;
		this.content = content;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
