<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Guest Login</title>
  <meta charset="utf-8">
  <link rel="icon" href="<c:url value="/resources/guestlogin/favicon.png"/>" type="image/gif">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/guestlogin/style.css"/>">
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
             <a class="nav-link home-nav" href="homelogin"><b><font color="white">Home</font></b>
             </a>
          </li>
         
          <li class="nav-item">
             <a class="nav-link signup-nav" href="signup.jsp" ><b><font color="blue">Sign up</font></b> </a>
          </li>
         
        </ul>
      </div>
    </div>
  </nav>
  <!--Login body --->
  <div class="container">
  <div clas="row rap">
  <div class="loginbox col-lg-4 col-mg-8 col-sm-12">
    <img src="<c:url value="/resources/guestlogin/avatar.png"/>" class="avatar">
        <h1>Guest Login</h1>
        <form action="verifylogin" method="post">
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username">
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password">
            <c:set var="loginentry" value="${entry}"/>
            <c:set var="loginentry2" value="1"/>
            <c:if test="${loginentry==loginentry2}">
            <p1 style="color:red; margin-bottom:0.5rem">Invalid Credentials</p1>
            </c:if>
            <input type="submit" value="verifylogin">
           <!--  <a href="#">Lost your password?</a><br> -->
            <a href="#">Don't have an account?</a>
        </form>
        
    </div>
  </div>
</div>
<!-- Footer -->
<footer class="page-footer font-small text-secondary">

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2020 Copyright:
    <a href="https://mdbootstrap.com/education/bootstrap/"> URLdropbox</a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->
</body>
</html>