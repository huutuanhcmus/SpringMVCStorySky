package com.tokyoboyband.model;

public class StoryModel extends AbstractModel<StoryModel> {
	private Long idCategory;
	private Long idStory;
	private String nameStory;
	private String introduceStory;
	private String imageStory;
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public Long getIdStory() {
		return idStory;
	}
	public void setIdStory(Long idStory) {
		this.idStory = idStory;
	}
	public String getNameStory() {
		return nameStory;
	}
	public void setNameStory(String nameStory) {
		this.nameStory = nameStory;
	}
	public String getIntroduceStory() {
		return introduceStory;
	}
	public void setIntroduceStory(String introduceStory) {
		this.introduceStory = introduceStory;
	}
	public String getImageStory() {
		return imageStory;
	}
	public void setImageStory(String imageStory) {
		this.imageStory = imageStory;
	}
	
	
	
}
