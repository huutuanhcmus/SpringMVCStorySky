package com.tokyoboyband.service;

import com.tokyoboyband.dto.StoryDTO;

public interface IStoryService {
	StoryDTO findOneById(Long id);
}
