package com.tokyoboyband.converter;

import org.springframework.stereotype.Component;

import com.tokyoboyband.dto.CollectionStoryDTO;
import com.tokyoboyband.entity.CollectionStoryEntity;

@Component
public class CollectionStoryConverter {
	public CollectionStoryDTO toDto(CollectionStoryEntity entity) {
		CollectionStoryDTO result = new CollectionStoryDTO();
		result.setName(entity.getName());
		result.setId(entity.getId());
		result.setContent(entity.getContent());
		result.setStory_id(entity.getStory().getId());
		result.setCreatedBy(entity.getCreatedBy());
		result.setModifiedBy(entity.getModifiedBy());
		result.setCreatedDate(entity.getCreatedDate());
		result.setModifiedDate(entity.getModifiedDate());
		return result;
	}
}
