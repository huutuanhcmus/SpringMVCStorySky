package com.tokyoboyband.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokyoboyband.converter.UserConverter;
import com.tokyoboyband.dto.UserDTO;
import com.tokyoboyband.entity.UserEntity;
import com.tokyoboyband.repository.UserRepository;
import com.tokyoboyband.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserConverter userConverter;
	@Override
	public UserDTO save(UserDTO user) {
		UserEntity story = userConverter.toEntity(user);
		
		if(userRepository.save(story) != null)
			return user;
		else
			return null;
	}

}
