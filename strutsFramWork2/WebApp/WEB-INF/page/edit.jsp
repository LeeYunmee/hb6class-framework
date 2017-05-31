<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정페이지</h1>
		<form action="update.action">
		<input type="text"  name="sabun" value="${bean.sabun }" hidden="hidden"/>
		<div>
			<label for="name">이름</label>
			<input type="text"  name="name"  id="name"  value="${bean.name }" />
		</div>
		<div>
			<label for="nalja">날짜</label>
			<input type="date"  name="nalja"  id="nalja"  value="${bean.nalja}" />
		</div>
		<div>
			<label for="pay">금액</label>
			<input type="number"  name="pay"  id="pay" value="${bean.pay }" />
		</div>
		<button>입력</button>
	</form>
</body>
</html>