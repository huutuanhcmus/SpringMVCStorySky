package com.tokyoboyband.dto;

import java.util.ArrayList;
import java.util.List;

public class StoryDTO extends AbstractDTO<StoryDTO> {
	private Long category_id;
	private String name;
	private String introduce;
	private String image;
	private List<CollectionStoryDTO> collectionStoryList = new ArrayList<CollectionStoryDTO>(0);
	
	public List<CollectionStoryDTO> getCollectionStoryList() {
		return collectionStoryList;
	}
	public void setCollectionStoryList(List<CollectionStoryDTO> collectionStoryList) {
		this.collectionStoryList = collectionStoryList;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
