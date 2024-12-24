<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SimpleTodo</title>
</head>
<body>
<h1>SimpleToDo</h1>
<p>
 
 <c:forEach var="todo" items="${todoList}">
	<p> 
	<c:out value="${todo.title}" />
	<c:out value="${todo.Content}" />
	<c:out value="${todo.createdAt}" />
	<c:out value="${todo.updatedAt}" />
	
	<c:if test="${not empty errorMsg}">
	<p><c:out value="${errorMsg}" /></p>
	</c:if>
	</p>
	</c:forEach>

</body>
</html>