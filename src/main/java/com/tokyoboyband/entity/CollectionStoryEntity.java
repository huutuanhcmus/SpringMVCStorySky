package com.tokyoboyband.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "collectionstory")
public class CollectionStoryEntity extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "story_id")
	private StoryEntity story;

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

	public StoryEntity getStory() {
		return story;
	}

	public void setStory(StoryEntity story) {
		this.story = story;
	}
	
	
}
