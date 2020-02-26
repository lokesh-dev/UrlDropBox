package com.dev.urldropbox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Test {
@ResponseBody	
@RequestMapping({"/signup","/login"})
public String tst (){
	return "<h>We are under construction try guest log in</h>";
}
@RequestMapping("/guest-login")
public String tst1() {
	return "guestlogin";
}
@RequestMapping("/homelogin")
public String tst2() {
	return "home";
}


}

/*
 * ModelMap hm=new ModelMap(); ModelMap mp=(ModelMap)
 * md.loadBookmarks(false,hm); Set<String> keys=mp.keySet();
 * 
 * for(String i:keys) {
 * System.out.println(i+":"+((Bookmark)mp.get(i)).getUrl()+((Bookmark)
 * mp.get(i)).getDescription()); }
 */