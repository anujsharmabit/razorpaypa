package com.pay.controller;

import java.util.Map;

import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pay.entity.StudentOrder;
import com.pay.service.Studentservice;
import com.razorpay.RazorpayException;

@Controller
public class StudentController {
	
	@Autowired
	private Studentservice studentservice;

	@GetMapping("/")
	public String init() {
		
		return "index";
	}
	
	@PostMapping("/createorder")
	@ResponseBody
	public ResponseEntity<StudentOrder>  createorder(@RequestBody StudentOrder studentOrder) throws RazorpayException{
		
		
	 StudentOrder  ordercreated =	studentservice.createorder(studentOrder);
		
	 return new ResponseEntity<>(ordercreated ,HttpStatus.CREATED);
		
	}
    
	@PostMapping("/updateorder")
	public String updateorder(@RequestParam Map<String, String> razorPayLoad){
		
		System.out.println(razorPayLoad);
		studentservice.updateorder(razorPayLoad);
		
		return "success";		
	}
	
	
}

