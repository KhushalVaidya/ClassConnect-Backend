package com.classconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.classconnect.model.UserRegister;
import com.classconnect.repository.UserRepositorty;


@Service
public class UserService {
	
	@Autowired
	UserRepositorty repository;

	public UserRegister register(UserRegister userRegister) {
		// TODO Auto-generated method stub
		
		return repository.save(userRegister);
	}

	public Optional<UserRegister> getUser(Long id) {
		// TODO Auto-generated method stub
		
		return repository.findById(id);
	}

	public List<UserRegister> getAllUser() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	

	public String deleteUserById(Long id) {
		// TODO Auto-generated method stub
		Optional<UserRegister> RegisterId=repository.findById(id);
		if(RegisterId.isPresent()) {
			repository.deleteById(id);
			return "User Account Deleted Successfully";
		}else {
			return "User Does Not Exist";
		}
		
	}

	public ResponseEntity<?> UpdateInfo(UserRegister register) {
		
		Long id = register.getId();
		
		Optional<UserRegister>  user = repository.findById(id);
		
		if(user.isPresent()) {
			
			UserRegister updateUser = user.get();
			
			updateUser.setName(register.getName());
			updateUser.setEmail(register.getEmail());
			updateUser.setAddress(register.getAddress());
			updateUser.setMobileNo(register.getMobileNo());
		
			return new ResponseEntity<>(repository.save(updateUser),HttpStatus.CREATED);
		}
		return new ResponseEntity<>("user not found",HttpStatus.BAD_REQUEST);
		
	}

}
