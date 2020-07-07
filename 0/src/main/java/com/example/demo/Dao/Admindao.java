package com.example.demo.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Admin;

@Repository
public interface Admindao extends CrudRepository<Admin, String> {
	public Admin findByAdminId(String AdminId);
	public Admin findBycontactNumber(String contactNumber);
}
