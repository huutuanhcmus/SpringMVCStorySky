package com.tokyoboyband.dto;

import java.util.ArrayList;

public class CategoryDTO extends AbstractDTO<CategoryDTO> {
	private String name;
	private String code;
	private ArrayList<StoryDTO> listStory = new ArrayList<StoryDTO>();
	
	public ArrayList<StoryDTO> getListStory() {
		return listStory;
	}
	public void setListStory(ArrayList<StoryDTO> listStory) {
		this.listStory = listStory;
	}
	public String getName() {
		return name;
	}
	public void setName(String nameCategory) {
		this.name = nameCategory;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String codeCategory) {
		this.code = codeCategory;
	}
	
	
}
