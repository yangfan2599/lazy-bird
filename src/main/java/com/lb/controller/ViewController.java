package com.lb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/login")
	public String login(){
		return "pages/login";
	}
	
	@RequestMapping("/notFound")
    public String toPage(){
        return "/pages/404";
    }
}
