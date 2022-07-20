package com.ncs.api.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.api.dto.JWTResponseDTO;
import com.ncs.api.dto.UserRequestDTO;
import com.ncs.api.exception.UserDuplicatedException;
import com.ncs.api.jwtutil.JWTUtil;
import com.ncs.api.model.User;
import com.ncs.api.service.PublicService;
import com.ncs.api.service.PublicServiceImpl;


@RestController
@RequestMapping("/abc-university/public")
@Validated
public class PublicController {
	
	@Autowired
	PublicService userService;
	
	@Autowired
	PublicServiceImpl userServiceImpl;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	//--------------------------------------------- Register --------------------------------------------------------------------------------------------------------------
	@PostMapping("/register")
	public ResponseEntity<User> doRegister(@RequestBody @Valid User user)throws UserDuplicatedException{
		User savedUser=userService.registerUser(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.OK);
	}
	
	
	//--------------------------------------------- Login --------------------------------------------------------------------------------------------------------------
	@PostMapping("/login")
	public ResponseEntity<JWTResponseDTO> doLogin(@RequestBody UserRequestDTO userEntry)throws Exception
	{
		System.out.println("----->> inside public/login "+userEntry);
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntry.getUsername(), userEntry.getPassword()));
			System.out.println();
			
		} catch (Exception e) {
			throw new Exception(e.toString());
		}

		UserDetails userDetails =  userServiceImpl.loadUserByUsername(userEntry.getUsername());
		
		String token = jwtUtil.generateToken(userDetails);
		
		boolean isValid = token!=null?true:false;
		
		JWTResponseDTO jwtResponseDTO = new JWTResponseDTO(token, userEntry.getUsername(), isValid);
		
		return new ResponseEntity<JWTResponseDTO>(jwtResponseDTO, HttpStatus.OK);
	}
	


}
