package com.dev.urldropbox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Bookmarkedit {
    Bookmark bk=new Bookmark(null, null);
	@RequestMapping(value="/addbookmark",method=RequestMethod.GET)
	public ModelAndView addBookmark(HttpServletRequest req,HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException
	{    ModelAndView mav=new ModelAndView();
		if(verifyloggedin(req)) {
        bk.setUrl(req.getParameter("url"));
	    bk.setDescription(req.getParameter("description"));
	    ModelDao m=new ModelDao();
	    m.saveBookmark(bk,false,(String)req.getSession().getAttribute("username"));
	    System.out.print(req.getParameter("url"));
        mav.setViewName("bookmarkself");
		mav.addObject("addbookmark", 2);
		ArrayList al=m.loadBookmarks(false,(String)req.getSession().getAttribute("username"));
        mav.addObject("bookmarks", al);
		return mav;
	  }
    mav.setViewName("home");		
	return mav;
	}
	@RequestMapping(value="/addnew")
	public ModelAndView addBookmarkinitialiser(HttpServletRequest req,HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException
	{ 
		ModelAndView mav=new ModelAndView();
		if(verifyloggedin(req)) {
		mav.setViewName( "bookmarkself");
		mav.addObject("addbookmark", 1);
		ModelDao m1=new ModelDao();
		ArrayList al=m1.loadBookmarks(false,(String)req.getSession().getAttribute("username"));
        mav.addObject("bookmarks", al);
		mav.setViewName("bookmarkself");
		return mav;
		}
		 mav.setViewName("home");
		 return mav;
		
	}
	@RequestMapping(value="/deletebookmark",method=RequestMethod.GET)
	public ModelAndView freshBookmarkinitializer(HttpServletRequest req,HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException
	{
	    ModelDao m=new ModelDao();
	    ModelAndView mav=new ModelAndView();
	    if(verifyloggedin(req)) {
	    String url=req.getParameter("delete");
        m.deleteBookmarks((String)req.getSession().getAttribute("username") , url);
		mav.addObject("addbookmark",0);
		mav.addObject("msg","Bookmark Deleted");
		ArrayList al=m.loadBookmarks(false,(String)req.getSession().getAttribute("username"));
        mav.addObject("bookmarks", al);
		mav.setViewName("bookmarkself");
		return mav;
	    }
	    mav.setViewName("home");
		 return mav;  
		
	}
	@RequestMapping(value="/editbookmarkhandler",method=RequestMethod.GET)
	public ModelAndView editBookmarkhandler(HttpServletRequest req,HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException
	{  
	   ModelAndView mav=new ModelAndView();
	   if(verifyloggedin(req)) {
	   String username=(String)req.getSession().getAttribute("username");
	   String url=req.getParameter("edit");
	   mav.addObject("bookmarktoedit", url);
	   ModelDao m=new ModelDao();
	   ArrayList al=m.loadBookmarks(false,username);
       mav.addObject("bookmarks", al);
       mav.setViewName("bookmarkself");
		return mav;
	    }
	   mav.setViewName("home");
	   return mav;  

	}	
	@RequestMapping(value="/edit-bookmark",method=RequestMethod.GET)
	public ModelAndView editBookmark(HttpServletRequest req,HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException
	{  
	    ModelAndView mav=new ModelAndView();
	    if(verifyloggedin(req)) {
	    ModelDao m=new ModelDao();
	    Bookmark b=new Bookmark(req.getParameter("url"),req.getParameter("newdescription"));
	    String username=(String)req.getSession().getAttribute("username");
		m.editBookmarkDescription(username, b);
		ArrayList al=m.loadBookmarks(false,(String)req.getSession().getAttribute("username"));
        mav.addObject("bookmarks", al);
        mav.setViewName("bookmarkself");
		return mav;
	    }
	   mav.setViewName("home");
	   return mav; 
	    
	}
	
	public boolean verifyloggedin(HttpServletRequest req) {
		if((String)req.getSession().getAttribute("username")==null) return false;
		return true;
	}
	
}
