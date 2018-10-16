<!-- 導入共用標籤 -->
<%@ include file="/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<!-- 導入共用設定 -->
<%@ include file="/common/html_header.jsp"%>
<title>CH04-03</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<h3>JSP的隱含變數</h3>
	<table>
		<thead>
			<tr>
				<th>變數</th>
				<th>型態</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>request</td>
				<td>HttpServletRequest</td>
			</tr>
			<tr>
				<td>response</td>
				<td>HttpServletResponse</td>
			</tr>
			<tr>
				<td>out</td>
				<td>JspWriter</td>
			</tr>
			<tr>
				<td>session</td>
				<td>HttpSession</td>
			</tr>
			<tr>
				<td>application</td>
				<td>ServletContext</td>
			</tr>
			<tr>
				<td>config</td>
				<td>ServletConfig</td>
			</tr>
			<tr>
				<td>pageContext</td>
				<td>JSPpage</td>
			</tr>
			<tr>
				<td>page</td>
				<td>this</td>
			</tr>
			<tr>
				<td>exception
				</td>
				<td>Throwable</td>
			</tr>
		</tbody>
	</table>
	<br>
	<hr>
	<%
		String a = "";
		request.getParameter("name");
		response.getWriter();
		out.print("1");
		session.getAttribute("name");
		application.getAttribute("name");
		config.getServletName();
		page.getClass();
	%>
</body>
</html>
