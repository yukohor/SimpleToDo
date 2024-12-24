<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SimpleTodo</title>
</head>
<body>
<h1>SimpleToDo</h1>
<p>
 
 <form action="Main" method="post">
 <input type="title" name="title">
 <input type="text" name="content">
 <input type="datetime" name="createdAt">
 <input type="datetime" name="updatedAt">
 <input type="submit" value="追加">
 </form>
 
 <c:forEach var="todo" items="${todoList}">
	<p>
	<c:out value="${todo.Title}" />
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