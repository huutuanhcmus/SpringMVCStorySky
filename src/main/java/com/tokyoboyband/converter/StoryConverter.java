package com.tokyoboyband.converter;

import org.springframework.stereotype.Component;

import com.tokyoboyband.dto.StoryDTO;
import com.tokyoboyband.entity.StoryEntity;

@Component
public class StoryConverter {
	public StoryDTO toDto(StoryEntity entity) {
		StoryDTO result = new StoryDTO();
		result.setName(entity.getName());
		result.setId(entity.getId());
		result.setIntroduce(entity.getIntroduce());
		result.setImage(entity.getImage());
		result.setCreatedBy(entity.getCreatedBy());
		result.setModifiedBy(entity.getModifiedBy());
		result.setCreatedDate(entity.getCreatedDate());
		result.setModifiedDate(entity.getModifiedDate());
		return result;
	}
}
