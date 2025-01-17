package com.tokyoboyband.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokyoboyband.converter.CollectionStoryConverter;
import com.tokyoboyband.dto.CollectionStoryDTO;
import com.tokyoboyband.entity.CollectionStoryEntity;
import com.tokyoboyband.entity.StoryEntity;
import com.tokyoboyband.repository.CollectionStoryRepository;
import com.tokyoboyband.repository.StoryRepository;
import com.tokyoboyband.service.ICollectionStotyService;

@Service
public class CollectionStoryService implements ICollectionStotyService {

	@Autowired
	private StoryRepository storyRepository;
	@Autowired
	private CollectionStoryRepository collectionStoryRepository;
	@Autowired
	private CollectionStoryConverter collectionStoryConverter;
	
	@Override
	public CollectionStoryDTO findOneById(Long id) {
		CollectionStoryEntity collectionStoryEntities = collectionStoryRepository.findOneById(id);
		CollectionStoryDTO resultsCollectionStoryDTO = collectionStoryConverter.toDto(collectionStoryEntities);
		return resultsCollectionStoryDTO;
	}

	@Override
	public CollectionStoryDTO save(CollectionStoryDTO dto) {
		CollectionStoryEntity collectionStory = collectionStoryConverter.toEntity(dto);
		collectionStory.setStory(storyRepository.findOne(dto.getStory_id()));
		if(collectionStoryRepository.save(collectionStory) != null)
			return dto;
		else
			return null;
	}

	@Override
	public void deleteOneById(Long id) {
		collectionStoryRepository.delete(id);
	}	
}
