package com.jspiders.userlocationapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.userlocationapp.dto.UserLocation;

public interface AdminDAO extends JpaRepository<UserLocation, String> {

}
