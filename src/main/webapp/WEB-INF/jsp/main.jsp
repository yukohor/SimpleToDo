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
 
 <form action="Main" method="post">
 <input type="title" name="text">
 <input type="textarea" name="content">
 <input type="datetime" name="createdAt">
 <input type="datetime" name="updatedAt">
 </form>

</body>
</html>