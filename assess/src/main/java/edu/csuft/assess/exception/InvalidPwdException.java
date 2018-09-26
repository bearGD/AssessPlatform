package edu.csuft.assess.exception;

public class InvalidPwdException extends Exception{

	public InvalidPwdException() {
		super("密码不正确");
	}
}
