<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="/common/include.jsp"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>CH07-index</title>
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
	<table>
		<thead>
			<tr>
				<th>dYear4</th>
				<th>dDate</th>
				<th>dTime</th>
				<th>dDatetime</th>
				<th>dTimestamp</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${beans}" var="item">
					<tr>
						<td><c:out value="${item.dYear4}" /></td>
						<td><c:out value="${item.dDate}" /></td>
						<td><c:out value="${item.dTime}" /></td>
						<td><c:out value="${item.dDatetime}" /></td>
						<td><c:out value="${item.dTimestamp}" /></td>
						<form action="${ctx}/ch10/date" method="POST">
							<input type="hidden" name="action" value="update">
							<input type="hidden" name="updateAction" value="updateInit">
							<input type="hidden" name="dYear4" value="${item.dYear4}">
							<td><input type="submit" value="Update"></td>
						</form>
						<form action="${ctx}/ch10/date" method="POST">
							<input type="hidden" name="action" value="delete">
							<input type="hidden" name="dYear4" value="${item.dYear4}">
							<td><input type="submit" value="Delete"></td>
						</form>
					</tr>
			</c:forEach>
			<c:if test="${beans eq null || fn:length(beans) eq 0}">
	        <tr>
	            <td colspan='5' class="listRowOdd" style="text-align:center">No Data!</td>
	        </tr>
	    </c:if>
		</tbody>
	</table>
	<a href="<c:out value='${ctx}'/>/ch10/date?action=init">回Date example</a>
</body>
</html>
