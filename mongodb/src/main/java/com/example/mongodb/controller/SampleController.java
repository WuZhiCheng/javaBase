package com.example.mongodb.controller;

import com.example.mongodb.dao.UserRepository;
import com.example.mongodb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class SampleController {

	@Autowired
	MongoTemplate mongotemplate;

	@RequestMapping("/a")
	@ResponseBody
	void add() {
		User user = new User();
		user.setId("1");
		user.setAge("12");
		user.setName("酒仙");
		mongotemplate.save(user);
	}

	@RequestMapping("/q1")
	@ResponseBody
	String q1() {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("酒仙"));
		String name = mongotemplate.findOne(query, User.class).getName();
		return name;
	}

	@Autowired
	UserRepository userRepository;

	@RequestMapping("/q")
	@ResponseBody
	String q2() {
		String name = userRepository.findByName("酒仙").getName();
		return name;
	}

}