package com.tokyoboyband.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokyoboyband.entity.CategoryEntity;


public interface CategoryRepository  extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneById(Long id);
}
