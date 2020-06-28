package com.tokyoboyband.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokyoboyband.converter.CollectionStoryConverter;
import com.tokyoboyband.converter.StoryConverter;
import com.tokyoboyband.dto.StoryDTO;
import com.tokyoboyband.dto.CollectionStoryDTO;
import com.tokyoboyband.entity.CollectionStoryEntity;
import com.tokyoboyband.entity.StoryEntity;
import com.tokyoboyband.repository.StoryRepository;
import com.tokyoboyband.service.IStoryService;

@Service
public class StoryService implements IStoryService {

	@Autowired
	private StoryRepository storyRepository;
	@Autowired
	private StoryConverter storyConverter;
	@Autowired
	private CollectionStoryConverter collectionStoryConverter;
	
	@Override
	public StoryDTO findOneById(Long id) {
		StoryDTO result = new StoryDTO();
		StoryEntity storyEntity = storyRepository.findOneById(id);
		List<CollectionStoryDTO> collectionStoryDtoList = new ArrayList<CollectionStoryDTO>(0);
		for(CollectionStoryEntity item : storyEntity.getCollectionStory()) {
			collectionStoryDtoList.add(collectionStoryConverter.toDto(item));
		}
		result = storyConverter.toDto(storyEntity);
		result.setCollectionStoryList(collectionStoryDtoList);
		return result;
	}
}
