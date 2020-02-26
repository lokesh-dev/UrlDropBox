package com.dev.urldropbox;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class Login {
@RequestMapping(value="/verifylogin",method=RequestMethod.POST)
public ModelAndView verifyLogin(HttpServletRequest req,HttpServletResponse res,ModelAndView mav) throws ClassNotFoundException, SQLException, IOException
{ 
	String username=req.getParameter("username");
	String password=req.getParameter("password");
	System.out.println(username+password +"check1");
	ModelDao2 m2=new ModelDao2();
	if(m2.verifyUser(username,password)) {
		HttpSession session=req.getSession();
		session.setAttribute("username", username);
		ModelDao m1=new ModelDao();
		ArrayList al=m1.loadBookmarks(false, username);
        mav.addObject("bookmarks", al);
		mav.setViewName("bookmarkself");
		return mav;
		}	    
    mav.addObject("entry", 1);
    mav.setViewName("guestlogin");
	return mav;
}

@RequestMapping(value="/logout")
public String logout(HttpServletRequest req,HttpServletResponse res,ModelAndView mav) throws ClassNotFoundException, SQLException, IOException
{ String username=(String) req.getSession().getAttribute("username");
  req.getSession().removeAttribute("username");
  req.removeAttribute("username");
return "guestlogin";
		
}



}
/*
else if((boolean) req.getAttribute("newguest")) {
 user.setUser_Name((String)req.getAttribute("newguestname"));
 user.setUser_Email((String)req.getAttribute("newguestemail"));
 user.setUser_Password((String)req.getAttribute("newguestpassword"));
 m.createNewGuest(user);
 HttpSession session=req.getSession();
 session.setAttribute("username", user);
 return "bookmarkself";
}
req.setAttribute("errorloginguest", 1);
return "guest";
}*/
