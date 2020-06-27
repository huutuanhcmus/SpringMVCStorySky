package com.tokyoboyband.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokyoboyband.converter.CategoryConverter;
import com.tokyoboyband.converter.StoryConverter;
import com.tokyoboyband.dto.CategoryDTO;
import com.tokyoboyband.dto.StoryDTO;
import com.tokyoboyband.entity.CategoryEntity;
import com.tokyoboyband.entity.StoryEntity;
import com.tokyoboyband.repository.CategoryRepository;
import com.tokyoboyband.repository.StoryRepository;
import com.tokyoboyband.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private StoryRepository storyRepository;
	@Autowired
	private CategoryConverter categoryConverter;
	@Autowired
	private StoryConverter storyConverter;
	
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> results = new ArrayList<CategoryDTO>();
		List<CategoryEntity> CategoryEntities = categoryRepository.findAll();
		for(CategoryEntity Categoryitem : CategoryEntities) {
			CategoryDTO CategoryResult = categoryConverter.toDto(Categoryitem);
			List<StoryEntity> StoryEntities = storyRepository.findByCategory(categoryRepository.findOneById(CategoryResult.getId()));
			ArrayList<StoryDTO> storyList = new ArrayList<StoryDTO>();
			for(StoryEntity StoryItem : StoryEntities) {
				storyList.add(storyConverter.toDto(StoryItem));
			}
			CategoryResult.setListStory(storyList);
			results.add(CategoryResult);
		}
		return results;
	}

}
