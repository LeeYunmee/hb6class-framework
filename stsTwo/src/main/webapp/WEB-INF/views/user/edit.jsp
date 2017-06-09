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
		<jsp:param value="2" name="mn" />
	</jsp:include>
	<div class="panel-body">
		<div class="page-header">
			<h1>
				${title }페이지<small>EditPage</small>
			</h1>
		</div>
		<form class="form-horizontal" action="" method="post">
			<div class="form-group">
				<label for="sabun" class="col-sm-2 control-label">사번</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="sabun"
						placeholder="사번입력">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name"
						placeholder="이름입력">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">${title }</button>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>