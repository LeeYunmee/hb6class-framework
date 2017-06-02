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
		<div>
			<label for="sabun">사번</label>
			<input type="text" name="bean.sabun"  id="sabun" value="${bean.sabun }" />
		</div>
			
		<div>
			<label for="name">이름</label>
			<input type="text" name="bean.name"  id="name" value="${bean.name }" />
			
			<s:fielderror/>
			<s:fielderror name="bean.name"/>
		</div>
		
		<div>
			<label for="pay">금액</label>
			<input type="text" name="bean.pay"  id="pay" value="${bean.pay }" />
		</div>
		<div>
			<button>수정</button>
		</div>
	</form>
</body>
</html>