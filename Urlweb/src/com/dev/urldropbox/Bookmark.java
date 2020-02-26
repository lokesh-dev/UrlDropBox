package com.dev.urldropbox;

public class Bookmark {
 private String url="";
 private String description="";
 public Bookmark(String url, String description) {
		super();
		this.url = url;
		this.description = description;
	}
 public String getUrl() {
	return url;
 }
 public String getDescription() {
	return description;
 }
 public void setUrl(String url) {
	this.url = url;
 }
 public void setDescription(String description) {
	this.description = description;
 }

}
