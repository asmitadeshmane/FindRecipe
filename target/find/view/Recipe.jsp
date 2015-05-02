<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Find Recipe</title>
</head>
<body>
You have successfully uploaded <s:property value="itemFileFileName"/>, <s:property value="recipeFileFileName"/><br>
<s:property value="csvMessage"/><br>
<s:property value="jsonMessage"/><br>
<hr>
Recipe for tonight: <s:property value="recipeFound"/>
<br />
<a href="home">Go Back</a> 
</body>
</html>