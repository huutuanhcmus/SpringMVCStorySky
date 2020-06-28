package com.tokyoboyband.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokyoboyband.entity.CategoryEntity;
import com.tokyoboyband.entity.StoryEntity;

public interface StoryRepository extends JpaRepository<StoryEntity, Long> {
	List<StoryEntity> findByCategory(CategoryEntity id);
	List<StoryEntity> findByCreatedByOrModifiedBy(String user1, String user2);
	StoryEntity findOneById(Long id);
}
