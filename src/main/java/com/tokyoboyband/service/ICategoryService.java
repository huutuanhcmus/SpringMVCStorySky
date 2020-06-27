package com.tokyoboyband.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tokyoboyband.dto.CategoryDTO;

public interface ICategoryService {
	List<CategoryDTO> findAll();
}
