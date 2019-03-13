package br.com.usjt.ccp3anmcahellospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ccp3anmcahellospringbootController {
	
	@GetMapping ("/hello")
	public String hello() {
		return "hello_spring_boot";
	}

}
