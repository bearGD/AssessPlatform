package edu.csuft.assess.exception;

public class InvalidNameException extends Exception{
	
	public InvalidNameException(String name) {
		super("用户名不存在: " + name);
	}

}
