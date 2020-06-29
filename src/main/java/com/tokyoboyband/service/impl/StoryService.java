package com.tokyoboyband.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokyoboyband.converter.CollectionStoryConverter;
import com.tokyoboyband.converter.StoryConverter;
import com.tokyoboyband.dto.StoryDTO;
import com.tokyoboyband.dto.CollectionStoryDTO;
import com.tokyoboyband.entity.CategoryEntity;
import com.tokyoboyband.entity.CollectionStoryEntity;
import com.tokyoboyband.entity.StoryEntity;
import com.tokyoboyband.repository.CategoryRepository;
import com.tokyoboyband.repository.CollectionStoryRepository;
import com.tokyoboyband.repository.StoryRepository;
import com.tokyoboyband.service.IStoryService;

@Service
public class StoryService implements IStoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private StoryRepository storyRepository;
	@Autowired
	private StoryConverter storyConverter;
	@Autowired
	private CollectionStoryRepository collectionStoryRepository;
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

	@Override
	public List<StoryDTO> findByCreatedByOrModifiedBy(String user) {
		List<StoryDTO> result = new ArrayList<StoryDTO>();
		List<StoryEntity> storyEntityList = storyRepository.findByCreatedByOrModifiedBy(user, user);
		for(StoryEntity item : storyEntityList) {
			result.add(storyConverter.toDto(item));
		}
		return result;
	}

	@Override
	public StoryDTO save(StoryDTO dto) {
		StoryEntity story = storyConverter.toEntity(dto);
		story.setCategory(categoryRepository.findOneById(dto.getCategory_id()));
		if(storyRepository.save(story) != null)
			return dto;
		else
			return null;
	}

	@Override
	public void delete(StoryDTO dto) {
		StoryEntity story = storyRepository.findOne(dto.getId());
		for(CollectionStoryEntity item : story.getCollectionStory()) {
			collectionStoryRepository.delete(item);
		}
		storyRepository.delete(dto.getId());
	}

	@Override
	public List<StoryDTO> findByName(String name) {
		List<StoryDTO> result = new ArrayList<StoryDTO>();
		List<StoryEntity> storyEntity = storyRepository.findByName(name);
		for(StoryEntity item : storyEntity) {
			result.add(storyConverter.toDto(item));
		}
		return result;
	}
}
