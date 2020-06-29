package com.tokyoboyband.service;

import java.util.List;

import com.tokyoboyband.dto.StoryDTO;

public interface IStoryService {
	StoryDTO findOneById(Long id);
	List<StoryDTO> findByCreatedByOrModifiedBy(String user);
	StoryDTO save(StoryDTO dto);
	void delete(StoryDTO dto);
	List<StoryDTO> findByName(String name);
}
