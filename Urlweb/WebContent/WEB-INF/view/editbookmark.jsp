<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Edit bookmark</title>
  <meta charset="utf-8">
  <link rel="icon" href="<c:url value="/resources/guestlogin/favicon.png"/>" type="image/gif">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <style>

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
  </style>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 

</head>
<body>
    <!--navigation bar configuration -->
    <nav class="navbar navbar-expand-md static-top nav-body">
    <div class="container">
      <a class="navbar-brand" href="#"><img src="<c:url value="/resources/guestlogin/brandlogo.png"></c:url>"> </a>
      <button class="navbar-toggler bg-light" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="" >
        <img src="<c:url value="/resources/guestlogin/hamburger.png"/>">
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
           <li class="nav-item ">
             <a class="nav-link home-nav" href="#"><b><font color="white">Home</font></b>
             </a>
          </li>
          
          <li class="nav-item">
             <a class="nav-link signup-nav" href="#" ><b><font color="blue">Log out</font></b> </a>
          </li>
         
        </ul>
      </div>
    </div>
  </nav>

<div style="margin-left:20%; margin-top:1rem"> <form action="edit-bookmark">
<p style="font-size:150% ">URL: </p>
<input type="text" name="editurl1" placeholder="${editurl}">
<p style="font-size:150% ">Description:</p>
<input type="text" name="editdescription1" placeholder="${editdescription}">
<input type="submit" value="Edit" name="${editurl}">
<input type="hidden" name="originalurl" placeholder="${editurl}">
<input type="hidden" name="originaldescription" placeholder="${editdescription}">

</form>
</div>

</body>
</html>