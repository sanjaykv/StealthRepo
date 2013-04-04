<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Stylincity - Login Form</title>

<!--STYLESHEETS-->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" media="screen" />

<!--SCRIPTS-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<!--Slider-in icons-->
<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});
	
	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
});
</script>

</head>
<body>

<!--WRAPPER-->
<div id="wrapper">

	<!--SLIDE-IN ICONS-->
    <div class="user-icon"></div>
    <div class="pass-icon"></div>
    <!--END SLIDE-IN ICONS-->

<!--LOGIN FORM-->
<form:form name="login-form" class="login-form" action="signin" commandName="userAccount" method="post" >
	<!--HEADER-->
    <div class="header">
    <h1>StylinCity - Login </h1>
    <span>${message}</span>
    </div>
    <!--END HEADER-->
	
    <div class="content">
		<form:input path="email" type="text" class="input username" value="Your Email" onfocus="this.value=''" />
	    <form:input path="password" type="password" class="input password" value="Your Password" onfocus="this.value=''" />
    </div>
    
    <!--FOOTER-->
    <div class="footer" align="center">
    <input type="submit" name="submit" value="Submit" class="button"/>
    </div>
    <!--END FOOTER-->
</form:form>
<!--END LOGIN FORM-->

</div>
<!--END WRAPPER-->

<!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->

</body>
</html>