package com.tokyoboyband.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<StoryEntity> story = new ArrayList<StoryEntity>(0);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<StoryEntity> getStory() {
		return story;
	}

	public void setStory(List<StoryEntity> story) {
		this.story = story;
	}
	
	
	
	
}
