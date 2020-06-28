package com.tokyoboyband.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokyoboyband.converter.CategoryConverter;
import com.tokyoboyband.converter.CollectionStoryConverter;
import com.tokyoboyband.dto.CategoryDTO;
import com.tokyoboyband.dto.CollectionStoryDTO;
import com.tokyoboyband.entity.CategoryEntity;
import com.tokyoboyband.entity.CollectionStoryEntity;
import com.tokyoboyband.repository.CollectionStoryRepository;
import com.tokyoboyband.repository.StoryRepository;
import com.tokyoboyband.service.ICollectionStotyService;

@Service
public class CollectionStoryService implements ICollectionStotyService {

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

}