package com.tokyoboyband.model;

import java.util.ArrayList;

public class CategoryModel extends AbstractModel<CategoryModel> {
	private Long idCategory;
	private String nameCategory;
	private String codeCategory;
	private ArrayList<StoryModel> listStory = new ArrayList<StoryModel>();
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public ArrayList<StoryModel> getListStory() {
		return listStory;
	}
	public void setListStory(ArrayList<StoryModel> listStory) {
		this.listStory = listStory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public String getCodeCategory() {
		return codeCategory;
	}
	public void setCodeCategory(String codeCategory) {
		this.codeCategory = codeCategory;
	}
	
	
}
