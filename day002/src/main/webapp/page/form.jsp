<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	span{
		color: blue;
	}
</style>
</head>
<body>
<div>${requestScope.msg }</div>
		<h2>입력/수정 페이지</h2>
		
		<form action="insert.do"  method="post">
			<div><label for="name">name</label><input type="text" name="name" id="name" value="${bean.name }"/><span>${err.name }</span></div>
			<div><label for="nalja">nalja</label><input type="date" name="nalja" id="nalja" value="${bean.nalja }"/><span>${err.nalja }</span></div>
			<div><label for="pay">pay</label><input type="number" name="pay" id="pay" value="${bean.pay }"/><span>${err.pay }</span></div>
			<button>입력</button>
		</form>
</body>
</html>