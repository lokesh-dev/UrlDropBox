package com.dev.urldropbox;

public class User {
  private String User_name;
  private String User_Email;
  private String User_Password;
  public void setUser_Name(String user_name) { 
	User_name = user_name;
  }
  public void setUser_Email(String user_Email) {
	User_Email = user_Email;
  }
  public void setUser_Password(String user_Password) {
	User_Password = user_Password;
  }
  public String getUser_Name() {
	return User_name;
  }
  public String getUser_Email() {
	return User_Email;
  }
  public String getUser_Password() {
	return User_Password;
  }

}
