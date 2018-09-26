package edu.csuft.assess.exception;

public class NotFoundSecureQueException extends Exception{

	public NotFoundSecureQueException() {
		super("该用户没有设置密保问题");
	}
}
