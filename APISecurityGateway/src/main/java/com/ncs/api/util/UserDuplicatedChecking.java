package com.ncs.api.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncs.api.model.User;
import com.ncs.api.repository.UserRepository;


@Component
public class UserDuplicatedChecking {
	@Autowired
	UserRepository userRepository;
	
	public boolean registerLoginChecking(User user) 
	{
		List<User> userList=userRepository.findAll();
		String username=user.getName();
		for(User u:userList) {
			if(u.getName().equalsIgnoreCase(username)) {
				return false;
			}
		}
		return true;
	}
}
