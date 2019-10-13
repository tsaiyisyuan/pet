<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜尋商品</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js">
	
</script>
</head>
<body bgcolor="#fdf5e6">
	<div align="center">
		<h2>搜尋商品</h2>
		<jsp:useBean id="pb" scope="request"
			class="com.tw.vo.PetBean" />
		<form method="post" action="${pageContext.request.contextPath}/PetProductsQueryId">
			輸入要查詢的商品編號:<input type="text" name="productId" />
			<input type="submit" value="送出" /> 
			</form>
			<form method="post" action="${pageContext.request.contextPath}/PetProductQueryName">
			輸入要查詢的商品名稱:<input type="text"name="productName" />
			<input type="submit" value="送出" />
		</form>
	</div>

</body>
</html>