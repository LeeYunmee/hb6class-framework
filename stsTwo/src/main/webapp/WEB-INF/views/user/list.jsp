<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/template/header.jsp"></jsp:include>
	<jsp:include page="/template/main.jsp">
		<jsp:param value="2" name="mn"/>		
	</jsp:include>
	<div class = "panel-body">
		<table>
			<tr>
				<th>연번</th>
				<th>사번</th>
				<th>이름</th>
				<th>날짜</th>
			</tr>
			<c:forEach items="${alist }" var="bean">
			<tr>
				<td>${bean.num }</td>
				<td><a href="detail?idx=${bean.num }">${bean.sabun }</a></td>
				<td>${bean.name }</td>
				<td>${bean.nalja }</td>
			</tr>
			</c:forEach>
		</table>
		<a href="add">입력</a>
	</div>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>