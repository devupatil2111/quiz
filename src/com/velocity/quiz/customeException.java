package com.velocity.quiz;

public class customeException extends RuntimeException {
customeException(String message){
	super(message);
	System.out.println(message);
}
}
