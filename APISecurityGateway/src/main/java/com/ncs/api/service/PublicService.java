package com.ncs.api.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ncs.api.exception.UserDuplicatedException;
import com.ncs.api.model.User;


@Service
public interface PublicService extends UserDetailsService{

	public User registerUser(User user) throws UserDuplicatedException;
}
