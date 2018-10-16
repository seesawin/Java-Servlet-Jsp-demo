<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>CH04-01</title>
</head>
<body>
	JSP與Servlet本質上都是一樣的東西，兩者都繼承了HttpServlet，但是JSP多繼承了HttpJspBase<br>
	Servlet與JSP都可以寫Java的語法，但這種方式會造成職責不清難以維護<br><hr>
	
	<table border="1">
		<tr align="center" bgcolor="99ccff">
			<td width="80">ID</td>
			<td width="80">姓名</td>
		</tr>

		<!-- java程式碼片段 -->
		<%
			int i;
			String color1 = "PINK";
			String color2 = "YELLOW";
			String name = "";
			int num = (int) (Math.random() * 8) + 5;
			for (i = 1; i <= num; i++) {
				String color = "";
				if (i % 2 == 0) {
					color = color1;
					name = "Alec";
				} else {
					color = color2;
					name = "Steven";
				}
				out.println("<tr align ='center' bgcolor=" + color + ">");
				out.println("<td >" + i + "</td>");
				out.println("<td>" + name + "</td>");
				out.println("</tr>");
			}
		%>
	</table>
	<br>
	<hr>

	<!-- java程式碼片段 -->
	<%
		java.util.Date d = new java.util.Date();
		int stock = (int) (Math.random() * 10) + 2;
	%>

	<table border="1">
		<tr align="center" bgcolor="99ccff">
			<th>Name</th>
			<th>品項</th>
			<th>數量</th>
			<th>訂購時間</th>
			<th>庫存數量</th>
			<th>是否可訂購</th>
		</tr>
		<tbody>
			<tr>
				<td><!-- java程式碼片段 -->
					<%
						String oName = request.getParameter("name");
						out.println(oName);
					%>
				</td>
				<td><!-- java程式碼片段 -->
					<%
						String product = request.getParameter("product");
						out.println(product);
					%>
				</td>
				<td><!-- java程式碼片段 -->
					<%
						int count = 0;
						try {
							count = Integer.parseInt(request.getParameter("count"));
						} catch (NumberFormatException e) {
							;
						}
						out.println(count);
					%>
				</td>
				<!-- 運算式取值-->
				<td><%=d%></td>
				<td><%=stock%></td>
				<td><%=hasStock(count, stock)%></td>
			</tr>
		</tbody>
	</table>
	<br>
	<hr>
	<ol><!-- java程式碼片段 -->
		<%
			for (int j = 1; j < 10; j++) {
		%>
		<li><%=100 / j%></li>
		<%
			}
		%>
	</ol>
	<br>
</body>
</html>

<!-- 宣告方方法-->
<%!public String hasStock(int count, int stock) {
		String has = "Y";
		if (count > stock) {
			has = "N";
		}
		return has;
	}%>
