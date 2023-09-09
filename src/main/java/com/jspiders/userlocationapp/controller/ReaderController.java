package com.jspiders.userlocationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jspiders.userlocationapp.dto.UserLocation;
import com.jspiders.userlocationapp.response.Response;
import com.jspiders.userlocationapp.service.ReaderService;

@Controller
@RequestMapping("/reader")
public class ReaderController {
	
	@Autowired
	private ReaderService service;
	
	@GetMapping("get_users/{N}")
	private ResponseEntity<Response> get_users(@PathVariable int N){
		List<UserLocation> users = service.get_users(N);
		if (users != null) {
			return new ResponseEntity<Response>(new Response("Data found. ", null, users), HttpStatus.FOUND);
		}
		return new ResponseEntity<Response>(new Response("Data not found. ", null, null), HttpStatus.NOT_FOUND);

	}

}
