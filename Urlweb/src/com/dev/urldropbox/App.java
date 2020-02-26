package com.dev.urldropbox;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class App{
	public String quickBookmark(HttpServletRequest req,HttpServletResponse res) {
	
	return "hello";
	}
}
