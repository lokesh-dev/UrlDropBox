package com.dev.urldropbox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.ui.ModelMap;

public class ModelDao {
 private String db_url="jdbc:mysql://localhost:3306/?user=root/userdata";
 private String db_uname="root";
 private String db_password="123456789";
 
 // to save bookmark into db
 public void saveBookmark(Bookmark bk,Boolean quickbookmar,String username) throws ClassNotFoundException, SQLException {
	String query="insert into userdata."+username+ " (`url`, `urldesc`, `quickbookmark`) values(?,?,?)";
    Class.forName("com.mysql.cj.jdbc.Driver");
   	Connection con=DriverManager.getConnection(db_url,db_uname,db_password);
   	
   	PreparedStatement st=con.prepareStatement(query);
   	System.out.print("bk.getUrl()"+"yhdy");
   
   	st.setString(1,bk.getUrl());
   	st.setString(2,bk.getDescription()); 
   	st.setString(3,"no"); 
   	st.executeUpdate();
 }
 //to load/view bookmark from db
 public ArrayList loadBookmarks(Boolean quickbookmark,String username) throws ClassNotFoundException, SQLException {
     ArrayList al=new ArrayList();
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection(db_url,db_uname,db_password);
	 Statement st=con.createStatement();
	 ResultSet rs;
	 if(quickbookmark) {  rs=st.executeQuery("Select * from "+"userdata"+"."+username+ " where quickbookmark='yes';");
	 }
	 else { rs=st.executeQuery("Select * from "+"userdata"+"."+username+";");
	 }
	 while(rs.next()) {
		 al.add(new Bookmark(rs.getString(2),rs.getString(3)));
	 }
	 st.close();
	 con.close();
	 return al;
}
 //to delete bookmark
 public void deleteBookmarks(String username,String selectedbookmark) throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection(db_url,db_uname,db_password);
	 Statement st=con.createStatement();
	 st.executeUpdate("delete from "+"userdata"+"."+username+" where url='"+ selectedbookmark+"';");
	 st.close();
	 con.close();
}
 //to edit bookmark
public void editBookmarkDescription(String username,Bookmark b) throws SQLException, ClassNotFoundException {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection(db_url,db_uname,db_password);
	 Statement st=con.createStatement();
	 st.executeUpdate("UPDATE userdata."+username+" SET `urldesc` = '"+b.getDescription()+"' WHERE (`url` = '"+b.getUrl()+"');");
	 st.close();
	 con.close();
	
}
public void editBookmarkUrl(String username,Bookmark b,String url) throws SQLException, ClassNotFoundException {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection(db_url,db_uname,db_password);
	 Statement st=con.createStatement();
	 int slno=getSlno(username,url);
	 System.out.println("inside edibookmark"+slno);
	 st.executeUpdate("UPDATE userdata."+username+" SET  = '"+b.getUrl()+"' WHERE (`slno` = '"+slno+"');");
	 st.close();
	 con.close();
	
}
public int getSlno(String username,String url) throws ClassNotFoundException, SQLException {
	 
	int slno=0;
	String temp="";
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection(db_url,db_uname,db_password);
	 Statement st=con.createStatement();
	 System.out.println(username+url+"usernameurl");
	 ResultSet rs=st.executeQuery("Select * from userdata."+username+" where (url='"+url+"');");
	 System.out.println(slno+"check1");
	 while(rs.next()) {
		slno=rs.getInt(1);
		 temp=rs.getString(3);
	    }
    System.out.println(slno+"check2"+temp);
	st.close();
	 con.close();
	return slno;
}
public String getDescription(String username,String url) throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection(db_url,db_uname,db_password);
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery("Select * from userdata."+username+" where (url='"+url+"');");
     String temp="";
	 while(rs.next()) {
	 temp=rs.getString(3);
    }
	st.close();
    con.close();
     return temp;
}
 
}
 

