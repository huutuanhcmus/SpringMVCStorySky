package com.tokyoboyband.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokyoboyband.entity.CollectionStoryEntity;

public interface CollectionStoryRepository extends JpaRepository<CollectionStoryEntity, Long> {
	CollectionStoryEntity findOneById(Long id);
}
