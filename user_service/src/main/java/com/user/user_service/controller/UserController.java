package com.user.user_service.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.user_service.entity.Contact;
import com.user.user_service.entity.User;
import com.user.user_service.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userid}")
	public User getUserHandler(@PathVariable("userid") Long userid) {
		
		User user  = this.userService.getUser(userid);
		
		String url = "http://contact-service:9002/contact/user/"+userid;
		
		List<Contact> list =  restTemplate.getForObject(url, List.class);
		
		user.getContacts().addAll(list);
		return user;

	}

}
