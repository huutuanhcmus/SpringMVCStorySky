package com.tokyoboyband.converter;

import org.springframework.stereotype.Component;

import com.tokyoboyband.dto.CategoryDTO;
import com.tokyoboyband.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryDTO toDto(CategoryEntity entity) {
		CategoryDTO result = new CategoryDTO();
		result.setId(entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		result.setCreatedBy(entity.getCreatedBy());
		result.setModifiedBy(entity.getModifiedBy());
		result.setCreatedDate(entity.getCreatedDate());
		result.setModifiedDate(entity.getModifiedDate());
		return result;
	}
}
