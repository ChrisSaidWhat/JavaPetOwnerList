<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner List</title>
<style>
	
	body {
		display: grid;
		grid-template-columns: 1fr 1fr 1fr;
		grid-template-rows: 1fr 1fr 1fr 1fr; 
		gap: 20px;
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
		padding: 20px;
		gap: 20px;
	}
	
	.ownerForm fieldset {
		border-color: #605856;
	}
	
	.animalForm {
		background-color: #ED6A5A;
		color: #F4F1BB;
		grid-column: 2/3;
		grid-row: 3/4;
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
<form  class="ownerForm" method="post" action="ownerNavigationServlet">
		<table>
			<c:forEach items="${requestScope.ownerEntries}" var="currentEntry">
				<tr>
					<td><input type="radio" name="id" value="${currentEntry.id}"></td>
					<td>${currentEntry.firstName}</td>
					<td>${currentEntry.lastName}</td>
					<td>${currentEntry.userName}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem">
		<input type="submit" value="delete" name="doThisToItem">
		<input type="submit" value="add" name="doThisToItem">
	</form>
</body>
</html>