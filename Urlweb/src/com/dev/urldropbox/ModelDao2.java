package com.dev.urldropbox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelDao2 {

	 private String db_url1="jdbc:mysql://localhost:3306/?user=root/userdata";
	 private String db_uname="root";
	 private String db_password="123456789";
	 private String db_url2="jdbc:mysql://localhost:3306/?user=root/userpersonaldata";
	public boolean verifyUser(String username,String password) throws ClassNotFoundException, SQLException{ 
		String query="Select count(*) from userpersonaldata.userlog where (password='"+password+"') and (username='"+username+"');" ;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(db_url2,db_uname,db_password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		System.out.println("check2");
		while(rs.next()) {
			System.out.println("check3");
			if(rs.getInt(1)==1) return true;
			
			 }
		return false;	
	}
	public boolean verifyGuest(String username,String password) throws ClassNotFoundException, SQLException{ 
		String query="Select count(*) from userpersonaldata.guestlog where (password='"+password+"') and (username='"+username+"');" ;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(db_url2,db_uname,db_password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			if(rs.getInt(1)>0) return true;
			 }
		return false;	
	}
	public boolean createNewUser(User u) throws ClassNotFoundException, SQLException{ 
		String query="CREATE TABLE userdata."+u.getUser_Name();
		String query2= "slno INT NOT NULL AUTO_INCREMENT, url VARCHAR(45) NOT NULL,urldesc VARCHAR(45) NULL,quickbookmark VARCHAR(45) NULL,PRIMARY KEY (slno))"; 
		String query3="INSERT INTO userpersonaldata.userlog (username,email,password) VALUES (?,?,?);";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(db_url1,db_uname,db_password);
		Statement st=con.createStatement();
		st.executeUpdate(query);
		st.close();
		con.close();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con2=DriverManager.getConnection(db_url1,db_uname,db_password);
		PreparedStatement st2=con2.prepareStatement(query3);
		st2.setString(1, u.getUser_Name());
		st2.setString(2,u.getUser_Email());
		st2.setString(3,u.getUser_Password());
	    st2.executeUpdate();
		st2.close();
		con2.close();
	    return true;
	} 	
	public boolean createNewGuest(User u) throws ClassNotFoundException, SQLException{ 
		String query="CREATE TABLE userdata."+u.getUser_Name();
		String query2= "slno INT NOT NULL AUTO_INCREMENT, url VARCHAR(45) NOT NULL,urldesc VARCHAR(45) NULL,quickbookmark VARCHAR(45) NULL,PRIMARY KEY (slno))"; 
		String query3="INSERT INTO userpersonaldata.userlog (username,email,password) VALUES (?,?,?);";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(db_url1,db_uname,db_password);
		Statement st=con.createStatement();
		st.executeUpdate(query);
		st.close();
		con.close();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con2=DriverManager.getConnection(db_url1,db_uname,db_password);
		PreparedStatement st2=con2.prepareStatement(query3);
		st2.setString(1, u.getUser_Name());
		st2.setString(2,u.getUser_Email());
		st2.setString(3,u.getUser_Password());
	    st2.executeUpdate();
		st2.close();
		con2.close();
	    return true;
	}
	 
	public User getUser(String username) throws ClassNotFoundException, SQLException {
		User user=new User();
		String query="Select * from userpersonaldata.guestlog where username='"+username+"';" ;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(db_url2,db_uname,db_password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			user.setUser_Name(rs.getString(2));
			user.setUser_Email(rs.getString(3));
		}
		return user;
	}
	

	
}
