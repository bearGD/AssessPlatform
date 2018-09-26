package edu.csuft.assess.exception;

public class NotFoundUserException extends Exception{
	
	public NotFoundUserException() {
		super("用户不存在");
	}
}
