package com.tokyoboyband.model;

public class Message {
	private String message;
	private String alert;
	private Long idStory;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	
	public void success(String message) {
		alert = "success";
		this.message = message;
	}
	
	public void danger(String message) {
		alert = "danger";
		this.message = message;
	}
	public Long getIdStory() {
		return idStory;
	}
	public void setIdStory(Long idStory) {
		this.idStory = idStory;
	}
}
