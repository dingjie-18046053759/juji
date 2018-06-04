package com.fmcq.util.exception;

import com.fmcq.util.constant.RetCode;


/**
 * 参数异常
 * 
 * @author Administrator
 * 
 */
public class ParamException extends Exception {
	private Exception e;
	
	public Exception getException() {
		return e;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -4953101753824966168L;

	public ParamException(String message) {
		super(message);
	}
	
	public ParamException(Exception e,String message) {
		super(message);
		this.e = e;
	}
	public ParamException(RetCode retCode,String message) {
		super(message);
	}
	
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
}
