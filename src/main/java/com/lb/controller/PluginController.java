package com.lb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.config.Config;

@RestController
@RequestMapping("/plugin/editor")
public class PluginController {
	
	@RequestMapping("/config")
	public void config(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
        request.setCharacterEncoding( "utf-8" );
    	response.setHeader("Content-Type" , "text/html");
    	out.write(Config.initConfig());
	}
	
}
