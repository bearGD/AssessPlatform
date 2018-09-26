package edu.csuft.assess.exception;

public class NotMatchPwdException extends Exception{

	public NotMatchPwdException() {
		super("旧密码不正确");
	}
}
