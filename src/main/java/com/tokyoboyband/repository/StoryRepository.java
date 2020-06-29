package com.tokyoboyband.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tokyoboyband.entity.CategoryEntity;
import com.tokyoboyband.entity.StoryEntity;

public interface StoryRepository extends JpaRepository<StoryEntity, Long> {
	List<StoryEntity> findByCategory(CategoryEntity id);
	List<StoryEntity> findByCreatedByOrModifiedBy(String user1, String user2);
	StoryEntity findOneById(Long id);
	@Query("SELECT story FROM StoryEntity story WHERE name like %?1%")
	List<StoryEntity> findByName(String name);
}
