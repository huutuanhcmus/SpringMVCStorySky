package com.tokyoboyband.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokyoboyband.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
