package com.ibm.academia.apirest.ruleta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.ruleta.services.RuletaDAO;

@RestController
@RequestMapping("/ruleta")
public class RuletaController 
{
	@Autowired
	private RuletaDAO ruletaDAO;
	
	
}