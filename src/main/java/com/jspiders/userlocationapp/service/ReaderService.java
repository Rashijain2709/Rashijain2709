package com.jspiders.userlocationapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.userlocationapp.dao.ReaderDAO;
import com.jspiders.userlocationapp.dto.UserLocation;

@Service
public class ReaderService {

	@Autowired
	private ReaderDAO repository;

	public List<UserLocation> get_users(int N) {
		List<UserLocation> findAll = repository.findAll();
		List<UserLocation> users = new ArrayList<>();
		for (UserLocation user : findAll) {
			if (!user.isExcluded()) {
				users.add(user);
			}
		}
		List<UserLocation> users_required = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			users_required.add(users.get(i));
		}
		return users_required;
	}

}
