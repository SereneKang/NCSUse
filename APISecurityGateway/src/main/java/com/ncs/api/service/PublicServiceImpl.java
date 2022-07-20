package com.ncs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ncs.api.exception.UserDuplicatedException;
import com.ncs.api.model.MyUserDetails;
import com.ncs.api.model.User;
import com.ncs.api.repository.UserRepository;
import com.ncs.api.util.UserDuplicatedChecking;


@Service
public class PublicServiceImpl implements PublicService {

	@Autowired
	UserRepository userRepository;
	
	
	
	@Autowired
	UserDuplicatedChecking userDuplicatedChecking;
	
	//-------------------------------------- Login -------------------------------------------------------------------------

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.getUsersByUsername(username);
		return new MyUserDetails(user);
	}

	//-------------------------------------- Register -------------------------------------------------------------------------

	@Override
	public User registerUser(User user) throws UserDuplicatedException{
		User savedUser=new User();
		if(user!=null) {

			boolean duplicatedChecking=userDuplicatedChecking.registerLoginChecking(user);
			if(duplicatedChecking) {
				savedUser=userRepository.save(user);
			}else {
				throw new UserDuplicatedException("Duplicated Username... Username entered: ",user.getName());
			}
		}else {
			throw new NullPointerException("Employee Info Is Null");
		}
		
		return savedUser;
	}
	


}
