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
		result.setCategory_id(entity.getCategory().getId());
		return result;
	}
	
	public StoryEntity toEntity(StoryDTO dto) {
		StoryEntity result = new StoryEntity();
		result.setName(dto.getName());
		result.setIntroduce(dto.getIntroduce());
		result.setImage(dto.getImage());
		result.setId(dto.getId());
		return result;
	}
}
