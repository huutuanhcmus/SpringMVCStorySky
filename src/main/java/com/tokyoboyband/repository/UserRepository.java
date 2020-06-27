package com.tokyoboyband.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokyoboyband.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserNameAndStatus(String name, int status);
}
