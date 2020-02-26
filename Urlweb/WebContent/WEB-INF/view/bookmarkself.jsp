<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList" %>   
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bookmarks</title>
  <meta charset="utf-8">
<link rel="icon" href="<c:url value="/resources/bookmarkself/favicon.png"/>>" type="image/gif">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    body{
    
    }
    .font{
    font-size:120%;
    font-family:  arial,Helvetica, sans-serif;
    text-align:center;
    }   

   .home-nav{
    margin-right:0.75rem;
    font-size:120%;
    font-family:  arial,Helvetica, sans-serif;
   }
   .signup-nav{
       margin-top:0.11rem;
       margin-right:0.75rem;
       font-size:110%;
       font-family:  arial,Helvetica, sans-serif;
   }
   .login-nav{
       margin-top:0.11rem;
       margin-right:0.75rem;
       font-size:105%;
       font-family:  arial,Helvetica, sans-serif;
   } 
   .nav-body{
       background-color:black;
   }
   .packet{
     background-color:rgb(230, 227, 230);
     border-radius: 1rem;
     margin-top: 0.5rem;
     height: 6rem;
     display: inline-block;
   }
   .packet:hover {
	background:linear-gradient(to bottom, #8e8e8f 5%, #aaa9a9 100%);
	background-color:#8b8a8a;
}   
.packet1{
     background-color:#E0E0E0;
     border-radius: 1rem;
     margin-top: 1rem;
     height: 10rem;
     display: inline-block;
   }
   .packet1:hover {

	background-color:#f5f5f5;
}

   .childpacket1{
     margin-top:0.5rem;
     border-radius: 1rem;
     margin-left: 5%;
     height: 5rem;
   }
   .childpacket2{
     margin-top: 0.5rem;
     border-radius: 1rem;
     margin-left: 2%;
     height: 5rem;
   }

   .myButton1 {
     margin-top: 0.5rem;
	box-shadow:inset 0px -2px 3px -9px #000000;
	background:linear-gradient(to bottom, #0e0d0d 5%, #161616 100%);
	background-color:#2e2e2e;
	border-radius:2px;
	border:1px solid #808080;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:12px;
	font-weight:bold;
	padding:6px 31px;
	text-decoration:none;
	text-shadow:0px 1px 0px #5f7994;
}
.myButton1:hover {
	background:linear-gradient(to bottom, #49494a 5%, #2e2e2e 100%);
	background-color:#5e5e5e;
}

  .myButton2{
     margin-top: 0.5rem;
	box-shadow:inset 0px -2px 3px -9px #000000;
	background:linear-gradient(to bottom, #0e0d0d 5%, #161616 100%);
	background-color:#2e2e2e;
	border-radius:2px;
	border:1px solid #808080;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:12px;
	font-weight:bold;
	padding:6px 24px;
	text-decoration:none;
	text-shadow:0px 1px 0px #5f7994;
}
.myButton2:hover {
	background:linear-gradient(to bottom, #49494a 25%, #2e2e2e 70%);
	background-color:#5e5e5e;
}
.addbookmarkpack:hover{

  background-color: rgb(231, 230, 228);
}  
  </style>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 

</head>
<body>
   <%
   response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
   response.setHeader("Pragma","no-cache");
   response.setHeader("Expires","0");
   if(session.getAttribute("username")==null){ response.sendRedirect("home.jsp");}
   %>

    <!--navigation bar configuration -->
    <nav class="navbar navbar-expand-md static-top nav-body">
    <div class="container">
      <a class="navbar-brand" href="#"><img src="<c:url value="/resources/bookmarkself/brandlogo.png"></c:url>"> </a>
      <button class="navbar-toggler bg-light" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="">
        <img src="bookmarkself/hamburger.png">
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
           <li class="nav-item ">
             <a class="nav-link home-nav" href="#"><b><font color="white">Quick Bookmarks</font></b>
             </a>
          </li>
          <li class="nav-item">
             <a class="nav-link signup-nav" href="logout" ><b><font color="blue">Log out</font></b> </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
 
<!--body add-->
<h2  style="text-align:center; margin-top:1rem">Saved Bookmarks</h2>
<div style="margin-left:20%; margin-top:2rem">
<a href="http://localhost:8080/Urlweb/home/addnew" style="font-size:150%"><image src="<c:url value="/resources/bookmarkself/iconplus.png" ></c:url>">Add new bookmark</a>
 <c:set var="addbookmark" value="${addbookmark}"/>
 <c:set var="addbookmark2" value="1"/>
 <c:if test="${addbookmark==addbookmark2}">
   <form action="addbookmark" method="get" style="margin-left:2%">
    <p style="margin-bottom:0 "><b>Url</b></p>
    <input type="text" name="url" placeholder="Enter URL or drag&drop">
    <p style="margin-bottom:0"><b>Description</b></p>    
    <input type="text" name="description" placeholder="Enter description"> 
    <input type="submit" value="Add bookmark">
     </form>
   </c:if> 
 <c:set var="addbookmark2" value="2"/>
  <c:if test="${addbookmark==addbookmark2}">
  <p style="color:green; font-size:150%; margin-left:5%">Bookmark added</p>
   </c:if> 
 </div>
 <hr>
 <p style="color:red;text-align:center">${msg}</p>
<div class="container pk">
<div class="row">
<c:forEach var="bookmark" items="${bookmarks}">
<c:if test="${bookmarktoedit==bookmark.url}">
<div class="packet1 col-lg-12 ml-auto row">

  <form action="edit-bookmark" style="margin-left:20%">
  <p style="font-size:150% ">Description:${bookmark.description}</p>
  <input type="text" name="newdescription" placeholder="Enter new Description">
  <input type="submit" value="Save Changes">
  <input type="hidden" name="url" value="${bookmark.url}">
  <div style="color:rgb(56, 56, 56); font-size: 90%;">URL:${bookmark.url}</div>
   </div> 
   </form>
</div>
</c:if>
<c:if test="${bookmarktoedit!=bookmark.url}">
<div class="packet col-lg-12 ml-auto row">
<div class="childpacket1 col-lg-8 col-md-8 col-8 " id="childpacket1">
  <a href="${bookmark.url}">
   <div class="packetdata">
   <div style="color:black; font-size: 130%">Description:${bookmark.description}
   </div>
   <div style="color:rgb(56, 56, 56); font-size: 90%;">URL:${bookmark.url}</div>
   </div> 
   <p class="packettext">Click here to redirect</p>  
  </a>
</div>
<div class="childpacket2 col-lg-2 col-2">
 <form action="editbookmarkhandler" class="deletemark">
<button name="edit" value="${bookmark.url}" class="myButton1">Edit</button>
</form>
<form action="deletebookmark" class="deletemark">
<button name="delete" value="${bookmark.url}" class="myButton2">Delete</button>
</form>
</div>
</div>
</c:if>


</c:forEach>
</div>
</div>


<!-- Footer -->
<footer class="page-footer font-small text-secondary">

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3"> 2020 Copyright:
    <a href="https://mdbootstrap.com/education/bootstrap/"> URLdropbox</a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->
</body>
</html>