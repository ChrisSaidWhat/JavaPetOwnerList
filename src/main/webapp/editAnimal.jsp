<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Animal</title>
<style>
	
	body {
		display: grid;
		grid-template-columns: 1fr 1fr 1fr;
		grid-template-rows: 1fr 1fr 1fr; 
		background-color: #E6EBE0;
	}
	
	form {
		display: grid; 
		align-items: center;
		justify-content: center;
	}

	form fieldset {
		display: grid; 
		align-items: center;
		justify-content: center;
		width: 20%;
		gap: 10px;
	}
	
	h1 {
		text-decoration: underline;
	}
	
	.center {
		display: flex;
		flex-direction: column;
		justify-content: center;
		gap: 10px;
		text-align:center;
	}
	
	header {
		grid-column: 1/4;
		grid-row: 1/2;
		text-align: center;
	}
	
	.headerText {
		width: 100%;
	}
	
	.ownerForm {
		background-color: #36C9C6;
		color: #605856;
		grid-column: 2/3;
		grid-row: 2/3;
		gap: 20px;
		padding: 20px;
	}
	
	.ownerForm fieldset {
		border-color: #605856;
	}
	
	.animalForm {
		background-color: #ED6A5A;
		color: #F4F1BB;
		grid-column: 2/3;
		grid-row: 2/3;
		gap: 20px;
		padding: 20px;
	}
	
	.animalForm fieldset {
		border-color: #F4F1BB;
	}
	
	.fullList {
		display: grid;
		justify-content: center;
		align-content: center;
		color: #93A3B1;
		background-color: #93A3B1;
		grid-column: 2/3;
		grid-row: 4/5;
	}
	
	.fullList button {
		width: 100px;
		height: 100px;
	}
	
	.fullList a {
		text-decoration: none;
		color: #93A3B1;
	}
</style>
</head>
<body>
	<form class="animalForm" action="editAnimalServlet" method="post">
		<h1>Make Edits To Animal: </h1>
		<label for="name">Name: </label>
		<input type="text" id="name" name="name" value="${toEdit.name}">
		
		<label for="type">Type: </label>
		<input type="text" id="type" name="type" value="${toEdit.type}">
		
		<label for="adoptDate">Adoption Date: </label>
		<input type="date" id="adoptDate" name="adoptDate" value="${toEdit.adoptDate}">
		
		<input type="hidden" name="id" value="${toEdit.id}">
		<input type="submit" value="Save Changes">
	</form>
</body>
</html>