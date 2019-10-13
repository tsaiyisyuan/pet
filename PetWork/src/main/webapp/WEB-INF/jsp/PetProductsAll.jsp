<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>產品資料</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js">
</script>
<style>
.btn-group .button {
	background-color: #FFCC99; /* Green */
	border: 1px solid #FF9966;
	color: #000000;
	padding: 15px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	cursor: pointer;
	float: left;
	margin: auto;
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
}

#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 60%;
	text-align: center;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	background-color: #FFBB66;
	color: white;
}

#body1 {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
}
</style>
</head>
<body id="body1">
	<div align="center">
		<nav>
			<h2>產品資料</h2>
			<form method="post" name="form1"
				action="${pageContext.request.contextPath}/PetProductUpdate">
				輸入要修改的商品編號:<input type="text" name="productId" id="pi" /> <input
					type="button" id="bt" value="送出" /><span id="sp"> </span>
			</form>
		</nav>
		<table id="customers">
			<tr>
				<th>產品編號
				<th>產品名稱
				<th>庫存
				<th>進貨成本
				<th>售價
				<th>刪除
				<th>修改 <c:forEach items="${pbs}" var="pbs" varStatus="s">
						<tr>
							<td name="pro" productid="${pbs.productId}">${pbs.productId}
							<td>${pbs.productName}
							<td>${pbs.quantity}
							<td>${pbs.cost}
							<td>${pbs.price}
							<td>
								<div class="btn-group">
									<form method="post"
										action="${pageContext.request.contextPath}/PetProductDelete">
										<input type="hidden" value="${pbs.productId}" name="productId">
										<input class="button" type="submit" value="刪除" />
									</form>
								</div>
							<td>
								<div class="btn-group">
									<form method="post"
										action="${pageContext.request.contextPath}/PetProductUpdate">
										<input type="hidden" value="${pbs.productId}" name="productId">
										<input class="button" type="submit" value="修改" />
									</form>
									<c:set var="count" value="${s.count}" />
								</div>
					</c:forEach>
		</table>
		<%-- <form method="post"
			action="${pageContext.request.contextPath}/PetProductDelete">
			輸入刪除商品編號:<input type="text" name="productId" /><input type="submit"
				value="送出" /> 
		</form>--%>

		<h3>共${count}筆資料</h3>
		
	</div>
	<Script>
		document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("bt").addEventListener("click", checkId);
		
		});
		let pros= document.getElementsByName("pro");
		pros.forEach(function(pro){
			pro.addEventListener("click",checkId);
		});
		
		
		
		
		function checkId() {
			let flag1=false;
			var id = document.getElementById("pi").value;
			var idLeng = id.length;
			let pros= document.getElementsByName("pro");
			pros.forEach(function(pro){
				var proId =pro.getAttribute("productid");
				console.log("proId="+ proId);
				if(id == proId){
					flag1 = true;
				}
			});
			if (id == "") { // 產品編號不得為空值
				document.getElementById("sp").innerHTML = "產品編號不得為空值";
			}else if(idLeng < 4 || idLeng > 4){ //產品編號不得小於等於4位數
				document.getElementById("sp").innerHTML = "產品編號長度需為4碼";
			}else if(flag1==false){//產品編號需是產品列表裡面有的
				document.getElementById("sp").innerHTML = "沒有這個產品編號";
			}else if(flag1) {
				document.form1.submit();
			}
		}
	</Script>
</body>
</html>