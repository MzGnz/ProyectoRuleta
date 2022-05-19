package com.ibm.academia.apirest.ruleta.exceptions;

public class BadRequestException extends RuntimeException
{
	public BadRequestException(String message)
	{
		super(message);
	}
	private static final long serialVersionUID = 1821023831159687789L;

}