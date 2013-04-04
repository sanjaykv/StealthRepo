<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Stylincity - Upload photos</title>

<!--STYLESHEETS-->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" media="screen" />

<!--SCRIPTS-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/ajaxupload.js"></script>

</head>
<body>

<!--WRAPPER-->
<div id="wrapper">

<!--USER STATS FORM-->
<form:form name="uploadphotos-form" class="login-form" action="uploaduserphotos" commandName="userProfile" method="post" >
	<!--HEADER-->
    <div class="header">
    <h1>StylinCity - Upload photos </h1>
    <span>${user}</span>
    </div>
    <!--END HEADER-->
	
	
	<div id="upload-area">
		<div id="preview">
			<img width="100px" height="100px" src="/images/icons/128px/zurb.png" id="thumb">
		</div>
	
		<form action="/playground/ajax_upload" id="newHotnessForm">
			<label>Upload a Picture of Yourself</label>
			<input type="file" size="20" id="imageUpload" class=" ">
			<button class="button" type="submit">Save</button>
		</form>
	</div>	
	
    <%-- <div class="content">
		<form:input path="gender" type="text" class="input username" value="Your Photo" onfocus="this.value=''" />
    </div>
     --%>
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