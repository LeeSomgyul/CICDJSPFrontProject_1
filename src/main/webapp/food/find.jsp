<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container
{
	margin-top: 50px;
}
.row
{
	margin: 0px auto;
	width: 960px;
}
p{
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<from method="post" action="find.do">
				<select name = "column" class="input-sm">
					<option value="address">주소</option>
					<option value="name">맛집명</option>
				</select>
				<input type="checkbox" name="type" value="한식">한식
				<input type="checkbox" name="type" value="양식">양식
				<input type="checkbox" name="type" value="일식">일식
				<input type="checkbox" name="type" value="중식">중식
				<input type="checkbox" name="type" value="분식">분식
				<input type="text" name="ss" class="input-sm" size=15 value="${ss}">
				<button class="btn btn-sm btn-primary">검색</button>
			</from>
		</div>
		<div class="row" style="margin-top: 20px">
			<!--  
				<c:forEach var="vo" items="${list }">
					<div class="col-sm-3">
						<a href="#">
							<div class="thumbnail">
								<img src="${vo.poster }" style="width: 250px;height: 130px">
							</div>
							<p>${vo.name }</p>
						</a>
					</div>
					<div class="row text-center" style="margin-top: 20px">
						
					</div>
				</c:forEach>
			-->
		</div>
	</div>
</body>
</html>