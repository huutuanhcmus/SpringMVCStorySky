package com.tokyoboyband.model;

public class CollectionStoryModel extends AbstractModel<CollectionStoryModel> {
	private Long idStory;
	private Long idCollectionStory;
	private String nameCollectionStory;
	private String contentCollectionStory;
	public Long getIdStory() {
		return idStory;
	}
	public void setIdStory(Long idStory) {
		this.idStory = idStory;
	}
	public Long getIdCollectionStory() {
		return idCollectionStory;
	}
	public void setIdCollectionStory(Long idCollectionStory) {
		this.idCollectionStory = idCollectionStory;
	}
	public String getNameCollectionStory() {
		return nameCollectionStory;
	}
	public void setNameCollectionStory(String nameCollectionStory) {
		this.nameCollectionStory = nameCollectionStory;
	}
	public String getContentCollectionStory() {
		return contentCollectionStory;
	}
	public void setContentCollectionStory(String contentCollectionStory) {
		this.contentCollectionStory = contentCollectionStory;
	}
	
	
}
