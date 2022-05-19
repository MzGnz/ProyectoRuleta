package com.ibm.academia.apirest.ruleta.exceptions;

public class NotFoundException extends RuntimeException
{
	public NotFoundException(String mesagge)
	{
		super(mesagge);
	}
	private static final long serialVersionUID = 8606243733533831637L;

}