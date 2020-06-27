package com.tokyoboyband.dto;

public class CollectionStoryDTO extends AbstractDTO<CollectionStoryDTO> {
	private Long story_id;
	private String name;
	private String content;
	public Long getStory_id() {
		return story_id;
	}
	public void setStory_id(Long story_id) {
		this.story_id = story_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
