<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Find Recipe</title>
<style type="text/css">
	.errorMessage {
		color: rgb(255, 0, 0);
	}
	
	..recipeFormClass  {
		width: 250px;
	}
	
	.recipeFormClass table, .recipeFormClass table tr, .recipeFormClass table tr td	{
		border: 1px solid black;
		border-collapse:collapse;
		padding: 3px;
	}
	
	.recipeFormClass table tr .tdLabel {
		font-weight: bold;
		background-color: rgb(130,200,150);
		color: rgb(250,250,250);
	}
	
	.submitButton {
	  color: rgb(0,0,0);
	  background: rgb(255,255,255);
	  font-weight: bold;
	  border: 1px solid black;
	  padding: 3px 5px;
	  width: 100px;
	}
	 
	.submitButton:hover {
	  color: rgb(255,255,255);
	  background: rgb(100, 240, 150);
	}
	
</style>
</head>
<body>
	<s:form action="findRecipe" method="post" enctype="multipart/form-data"
		cssClass="recipeFormClass">
		
		<s:textfield type="file" name="itemFile" label="Upload list of items" />

		<s:textfield type="file" name="recipeFile"
			label="Upload collection of recipes" />
		<s:submit value="Upload" align="center" cssClass="submitButton"/>

	</s:form>

</body>

</html>