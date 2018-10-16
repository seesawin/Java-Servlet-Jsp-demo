<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CH02-request</title>
</head>
<body> 
<h3>GET-Request</h3>
<form action="/Java-Servlet-Jsp-demo/ch02/01" method="GET">
	<input type="hidden" name="action" value="get">
	姓名:<input type="text" name="mName"><br>
	年齡:<input type="text" name="mAge"><br>
	<input type="radio" name="sex" value="boy">boy &nbsp;
	<input type="radio" name="sex" value="girl">girl<br>
	<select name="location">
		<option value="台北">台北</option>
		<option value="桃園">桃園</option>
		<option value="新竹">新竹</option>
	</select>
	<input type="submit" value="confirm">
</form>

<h3>POST-Request</h3>
<form action="/Java-Servlet-Jsp-demo/ch02/01" method="POST">
	<input type="hidden" name="action" value="post">
	姓名:<input type="text" name="mName"><br>
	年齡:<input type="text" name="mAge"><br>
	<input type="radio" name="sex" value="boy">boy &nbsp;
	<input type="radio" name="sex" value="girl">girl<br>
	<select name="location">
		<option value="台北">台北</option>
		<option value="桃園">桃園</option>
		<option value="新竹">新竹</option>
	</select>
	<input type="submit" value="confirm">
</form>
</body>
</html>
