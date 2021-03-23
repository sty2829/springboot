package com.spboot.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@GetMapping("/")
	public @ResponseBody List<String> hello() {
		List<String> strList = new ArrayList<>();
		strList.add("hi");
		strList.add("hello");
		strList.add("안녕");
		return strList;
	}
	
	@PostMapping("/")
	public @ResponseBody List<String> hello1() {
		List<String> strList = new ArrayList<>();
		strList.add("hi");
		strList.add("hello");
		strList.add("안녕");
		return strList;
	}
	
	@GetMapping("/views/**")
	public void goView() {
		
	}
}
