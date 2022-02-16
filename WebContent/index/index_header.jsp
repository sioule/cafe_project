<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
		function changeView1(value){
			if(value=="0")
				location.href="index.jsp?contentPage=firstview.jsp";
			else if(value=="1")
				location.href="index.jsp?contentPage=test.jsp";
			else if(value=="2")
				location.href="index.jsp?contentPage=test.jsp";
			else if(value=="3")
				location.href="index.jsp?contentPage=test.jsp";
		}
</script>
</head>
<body>
	<!-- index header -->
	<header class="index-header">

		<div class="header-nav">
			<% 
				String id = (String)session.getAttribute("id");
				if(id == null) {
			%>
			<jsp:include page="index_header_logout.jsp" />
			<%} else {%>
			<jsp:include page="index_header_login.jsp" />
			<%}%>
		</div>

	</header>
</body>
</html>