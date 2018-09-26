package edu.csuft.assess.exception;

public class InvalidAuthorityException extends Exception{
	
	public InvalidAuthorityException() {
		super("用户权限不正确");		
	}
}
