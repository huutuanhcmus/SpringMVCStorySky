package com.tokyoboyband.service;

import com.tokyoboyband.dto.CollectionStoryDTO;

public interface ICollectionStotyService {
	CollectionStoryDTO findOneById(Long id);
	CollectionStoryDTO save(CollectionStoryDTO dto);
}
