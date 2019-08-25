package com.example.msscbeerservice.exception;

import java.io.Serializable;

public class MyException extends Exception implements Serializable {

	public MyException() {
		super();
	}
	
	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 324471480330543480L;
	
	

}
