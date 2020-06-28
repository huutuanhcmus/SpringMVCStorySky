package com.tokyoboyband.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokyoboyband.entity.CollectionStoryEntity;
import com.tokyoboyband.entity.StoryEntity;

public interface CollectionStoryRepository extends JpaRepository<CollectionStoryEntity, Long> {
	CollectionStoryEntity findOneById(Long id);
	void deleteByStory(StoryEntity story);
	List<CollectionStoryEntity> findByStory(StoryEntity story);
}
