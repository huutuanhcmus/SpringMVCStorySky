package com.tokyoboyband.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "story")
public class StoryEntity extends BaseEntity {
	@Column(name = "name")
	private String name;
	
	@Column(name = "introduce")
	private String introduce;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

	@OneToMany(mappedBy = "story", fetch = FetchType.LAZY)
	private List<CollectionStoryEntity> collectionStory = new ArrayList<CollectionStoryEntity>(0);
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

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<CollectionStoryEntity> getCollectionStory() {
		return collectionStory;
	}

	public void setCollectionStory(List<CollectionStoryEntity> collectionStory) {
		this.collectionStory = collectionStory;
	}
	
	
}
