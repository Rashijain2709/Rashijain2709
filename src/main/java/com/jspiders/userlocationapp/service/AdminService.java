package com.jspiders.userlocationapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.userlocationapp.dao.AdminDAO;
import com.jspiders.userlocationapp.dto.UserLocation;

@Service
public class AdminService {

	@Autowired
	private AdminDAO repository;

	public UserLocation create_data(UserLocation dto) {
		UserLocation userLoc = repository.save(dto);
		return userLoc;
	}

	public UserLocation update_data(UserLocation dto) {
		UserLocation userLoc = repository.save(dto);
		return userLoc;
	}

	public UserLocation delete_data(String name) {
		UserLocation userLoc = repository.findById(name).orElse(null);
		repository.deleteById(name);
		return userLoc;
	}

	public List<UserLocation> get_users(int N) {
		List<UserLocation> findAll = repository.findAll();
		List<UserLocation> users = new ArrayList<>();
		for (UserLocation user : findAll) {
			if (!user.isExcluded()) {
				users.add(user);
			}
		}
		List<UserLocation> users_required = new ArrayList<>();
		for (int i= 1; i<=N;i++) {
			users_required.add(users.get(i));
		}
		return users_required;
	}

}
