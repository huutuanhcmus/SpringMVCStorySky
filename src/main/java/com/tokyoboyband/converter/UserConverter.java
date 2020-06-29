package com.tokyoboyband.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.tokyoboyband.dto.UserDTO;
import com.tokyoboyband.entity.UserEntity;
import com.tokyoboyband.repository.RoleRepository;

@Component
public class UserConverter {
	@Autowired
	private RoleRepository roleRepository;
	
	public UserEntity toEntity(UserDTO dto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		UserEntity result = new UserEntity();
		result.setUserName(dto.getUsername());
		String password = passwordEncoder.encode(dto.getPassword());
		result.setPassword(password);
		result.setFullName(dto.getFullname());
		result.setStatus(1);
		result.setRole(roleRepository.findOne(2l));
		return result;
	}
}
