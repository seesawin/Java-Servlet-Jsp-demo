<%@ include file="/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<%@ include file="/common/html_header.jsp"%>
<title>CH04-02</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

.listRowEven{
	background-color: #CCDDFF
}

.listRowOdd{
	background-color: #FFDDAA
}

th {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<h3>JSTL標籤</h3>
	<table>
	    <tr>
	        <th>訂單編號目</th>
	        <th>訂單日期</th>
	        <th>客戶編號</th>
	        <th>訂單金額</th>
	    </tr>
	    <c:set var="rowCnt" scope="page" value="0"/>
	    <c:forEach var="ob" items="${requestScope.obList}">
	        <c:choose>
	            <c:when test="${pageScope.rowCnt % 2 == 0}">
	                <c:set var="styleClass" value="listRowEven" scope="page"/>
	            </c:when>
	            <c:otherwise>
	                <c:set var="styleClass" value="listRowOdd" scope="page"/>
	            </c:otherwise>
	        </c:choose>
	        <tr class="<c:out value="${pageScope.styleClass}"/>">
	            <td><c:out value="${ob.orderNo}"/></td>
	            <td>
		            <c:if test="${not empty ob.orderDate}">
		            	<fmt:formatDate pattern="yyyy-MM-dd" value="${ob.orderDate}"/>
	        		</c:if>
        		</td>
	            <td><c:out value="${ob.customerID}"/></td>
	            <td><fmt:formatNumber pattern="#,###.##" value="${ob.amount}"/></td>
	        </tr>
	        <c:set var="rowCnt" scope="page" value="${pageScope.rowCnt + 1}"/>
	    </c:forEach>
	    
		<c:if test="${requestScope.obList eq null || fn:length(requestScope.obList) eq 0}">
	        <tr>
	            <td colspan='4' class="listRowOdd" style="text-align:center">No Data!</td>
	        </tr>
	    </c:if>
	</table>
</body>
</html>
