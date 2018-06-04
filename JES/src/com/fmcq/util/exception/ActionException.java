package com.fmcq.util.exception;

/**
 * 
 * @date 2014-5-26 下午03:21:40
 * @author qinfz
 *
 */
public class ActionException extends Exception{

	/**  */
	private static final long serialVersionUID = 1L;

	public ActionException(){
		super();
	}
	public ActionException(String info){
		super(info);
	}
	public ActionException(Exception e){
		super(e);
	}
	public ActionException(String info,Exception e){
		super(info,e);
	}
}
