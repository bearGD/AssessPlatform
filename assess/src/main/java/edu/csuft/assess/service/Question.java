package edu.csuft.assess.service;

public class Question {
	
	String securequstion;
	String secureanswer;
	
	public Question() {
	}

	public Question(String securequstion, String secureanswer) {
		super();
		this.securequstion = securequstion;
		this.secureanswer = secureanswer;
	}

	public String getSecurequstion() {
		return securequstion;
	}

	public void setSecurequstion(String securequstion) {
		this.securequstion = securequstion;
	}

	public String getSecureanswer() {
		return secureanswer;
	}

	public void setSecureanswer(String secureanswer) {
		this.secureanswer = secureanswer;
	}
	
	
}
