<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% request.setCharacterEncoding("utf-8"); %>

<%
    String contentPage=request.getParameter("contentPage");
	if(contentPage==null)
		contentPage="admin_firstview.jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin_index</title>
<link href="./../css/index.css" rel="stylesheet" type="text/css" />
<link href="./../css/admin.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div id="wrap">
		<div id="header_inclu">
			<jsp:include page="./admin_header.jsp"/>
		</div>
		<div id="main">
			<jsp:include page="<%=contentPage%>" />
		</div>
		<div id="footer">
			<jsp:include page="./../index/footer.jsp" />
		</div>
	</div>

</body>
</html>