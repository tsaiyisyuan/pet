<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首頁</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js">
	
</script>
<style>
.btn-group .button {
	background-color: #FFCC99; /* Green */
	border: 1px solid #FF9966;
	color: #000000;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	cursor: pointer;
	float: left;
	width: 30%
}

.btn-group
 
.button
:not
 
(
:last-child
 
)
{
border-right
:
 
none
; /* Prevent double borders */


}
.btn-group .button:hover {
	background-color: #FF9966;
}

#allpage {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	height: 800px;
	width: 1024px;
	margin: 0 auto;
	align: center;
}
</style>
</head>
<body>

	<div id="allpage">
		<div align="center">

			<nav class="nav">
			<jsp:useBean id="pb" scope="request"
			class="com.tw.vo.PetBean" />
				<div class="btn-group">
					<form method="post"
						action="${pageContext.request.contextPath}/PetProductsAll">
						<input class="button" type="submit" value="全部資料">
					</form>
					<form method="post" action="PetProductsNew.jsp">
						<input class="button" type="submit" value="新增產品">
					</form>
					<form method="post" action="${pageContext.request.contextPath}/PetProductsQuery">
						<input class="button" type="submit" value="搜尋商品">
					</form>
				</div>
			</nav>
		</div>
		<article>
			<div>
				<img src="${pageContext.request.contextPath}/Image/cat.jpg"
					title="work" width=90%>
			</div>
		</article>
	</div>
</body>
</html>