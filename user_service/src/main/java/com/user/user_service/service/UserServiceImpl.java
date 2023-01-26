package com.user.user_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user.user_service.entity.User;
@Service
public class UserServiceImpl implements UserService{
	
	
	List<User> list = List.of(
			new User(1L, "sai", "1234567890"),
			new User(2L, "prasad", "0987654321"),
			new User(3L, "saiprasad", "1987654321")
            );

	@Override
	public User getUser(Long id) {
		return list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
		
	}

}
