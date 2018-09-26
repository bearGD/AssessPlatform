package edu.csuft.assess.exception;

public class NotFoundEvaluateException extends Exception{
	
	public NotFoundEvaluateException() {
		super("没有找到学员对该教员的相关评价");
	}
}
