package com.jspiders.userlocationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jspiders.userlocationapp.dto.UserLocation;
import com.jspiders.userlocationapp.response.Response;
import com.jspiders.userlocationapp.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping("/create_data")
	private ResponseEntity<Response> create_data(@RequestBody UserLocation dto) {
		UserLocation userLoc = service.create_data(dto);
		if (userLoc != null) {
			return new ResponseEntity<Response>(new Response("Data added. ", userLoc, null), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Response>(new Response("Data not added. ", null, null), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PatchMapping("/update_data")
	private ResponseEntity<Response> update_date(@RequestBody UserLocation dto){
		UserLocation userLoc = service.update_data(dto);
		if (userLoc != null) {
			return new ResponseEntity<Response>(new Response("Data updated. ", userLoc, null), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Response>(new Response("Data not updated. ", null, null), HttpStatus.NOT_ACCEPTABLE);

	}
	
	@DeleteMapping("/delete_data/{name}")
	private ResponseEntity<Response> delete_data(@PathVariable String name){
		UserLocation userLoc = service.delete_data(name);
		if (userLoc != null) {
			return new ResponseEntity<Response>(new Response("Data deleted. ", userLoc, null), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Response>(new Response("Data not deleted. ", null, null), HttpStatus.NOT_ACCEPTABLE);

	}
	
	@GetMapping("get_users/{N}")
	private ResponseEntity<Response> get_users(@PathVariable int N){
		List<UserLocation> users = service.get_users(N);
		if (users != null) {
			return new ResponseEntity<Response>(new Response("Data found. ", null, users), HttpStatus.FOUND);
		}
		return new ResponseEntity<Response>(new Response("Data not found. ", null, null), HttpStatus.NOT_FOUND);

	}

}
