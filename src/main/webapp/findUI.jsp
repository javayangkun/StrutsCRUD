<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<caption>用户列表</caption>
		<tr>
			<th>id</th>
			<th>姓名</th>
			<th>时间</th>
			<th>金钱</th>
		</tr>
		<c:forEach var="page" items="${page.list}">
			<tr>
				<td>${page.id }</td>
				<td>${page.name }</td>
				<td>${page.birthday }</td>
				<td>${page.money}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">
			<a href="User_find?p=1">首页</a>
			<a href="User_find?p=${page.prev }">上一页</a>
			<a href="User_find?p=${page.next }">下一页</a>
			<a href="User_find?p=${page.maxPage }">末页</a>
			</td>
		</tr>
	</table>
</body>
</html>