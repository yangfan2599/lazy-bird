package com.lb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lb.global.Result;

@RestController
public class UploadController {

	@RequestMapping("/upload")
	public Result upload(@RequestParam("file") MultipartFile file){
		return Result.success();
	}
}
