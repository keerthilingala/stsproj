package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Feedbackquestions;

public interface feedbackdao extends CrudRepository<Feedbackquestions,Integer>

{
	public List<Feedbackquestions>  findAll();
	public Feedbackquestions findBycustomerId(int customerId);


}
