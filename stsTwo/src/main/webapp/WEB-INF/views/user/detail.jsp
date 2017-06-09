<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="panel-body">
		<div class="page-header">
			<h1>상세페이지<small>${bin.name }님의 정보</small></h1>
		</div>
		<ul class="list-group">
			<li class=list-group-item">
				<h2>연번</h2>${bin.num }
			</li>
			
			<li class=list-group-item">
				<h2>사번</h2>${bin.sabun }
			</li>
			
			<li class=list-group-item">
				<h2>이름</h2>${bin.name }
			</li>
			
			<li class=list-group-item">
				<h2>날짜</h2>${bin.nalja }
			</li>
		</ul>
	</div>	
	<a href="edit?num=${bin.num }">수정</a>
	<a href="delete?num=${bin.num }">삭제</a>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>