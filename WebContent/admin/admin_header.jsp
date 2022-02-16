<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./../js/admin_index.js"></script>
</head>
<body>
	<header class="index-header">

		<div class="header-nav">
			<div align="center" class="text-box">
				<span class="header-menu" onclick="changeBody(0)">HOME</span>
				<span class="header-menu" onclick="changeBody(1)">MENU</span>
				<span class="header-menu" onclick="changeBody(2)">NOTICE BOARD</span>
			</div>

			<div class="logo-box">
				<span class="welcom-id"><%=session.getAttribute("id")%>님 환영합니다</span>
				<a class="mypage" href="./admin_test.jsp">admin PAGE</a>
			</div>
		</div>

	</header>


</body>
</html>