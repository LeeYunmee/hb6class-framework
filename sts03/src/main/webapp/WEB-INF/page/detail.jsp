<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/template/header.jsp"></jsp:include>
	<jsp:include page="/template/menu.jsp"></jsp:include>

	<jsp:include page="/template/article.jsp">
		<jsp:param name="h1" value="Detail" />
		<jsp:param name="p" value="selectOne..." />
	</jsp:include>
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li><a href="#">list</a></li>
			<li><a href="#">detail</a></li>
		</ol>
	</div>
	<div class="col-md-12">
		<div class="page-header">
			<h1>
				상세페이지 <small>${bean.sabun }님의 상세정보</small>
			</h1>
		</div>
	</div>
	<div class="col-md-12">
		<div class="col-md-3 col-md-offset-3 text-right">사번</div>
		<div class="col-md-3">${bean.sabun }</div>
		<div class="col-md-3 col-md-offset-3 text-right">이름</div>
		<div class="col-md-3">${bean.name }</div>
		<div class="col-md-3 col-md-offset-3 text-right">날짜</div>
		<div class="col-md-3">${bean.nalja }</div>
		<div class="col-md-3 col-md-offset-3 text-right">금액</div>
		<div class="col-md-3">${bean.pay }</div>
		<div class="col-md-3 col-md-offset-3 text-right">
			<a class="btn btn-primary" href="edit.do?sabun=${bean.sabun }">수정</a>
			<a class="btn btn-primary" href="delete.do?sabun=${bean.sabun }">삭제</a>
		</div>
	</div>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>
