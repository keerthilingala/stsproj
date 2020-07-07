package com.example.demo.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.SupportAnalyst;


@Repository
public interface SupportAnalystdao extends CrudRepository<SupportAnalyst, String> {
	public SupportAnalyst findByAnalystId(String analystId);
	public SupportAnalyst findBycontactNumber(String contactNumber);

}

