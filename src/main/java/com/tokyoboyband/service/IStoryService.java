package com.tokyoboyband.service;

import java.util.List;

import com.tokyoboyband.dto.StoryDTO;

public interface IStoryService {
	StoryDTO findOneById(Long id);
	List<StoryDTO> findByCreatedBy(String user);
	StoryDTO save(StoryDTO dto);
}
