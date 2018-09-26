package edu.csuft.assess.exception;

public class NotFoundMemberException extends Exception{

	public NotFoundMemberException() {
		super("该角色的成员不存在");
	}
}
