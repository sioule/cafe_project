<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %> 
<%@ page import="dao.ProductDAO"%>
<%@ page import="dto.ProductDTO"%>

<%
	ProductDAO product_dao = new ProductDAO();
	String product_id = request.getParameter("product_id");
	ProductDTO product_dto = product_dao.getProduct(Integer.parseInt(product_id));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu 상세페이지</title>
<link href="./../css/index.css" rel="stylesheet" type="text/css" />
<link href="./../css/product.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="./../index/index_header.jsp"/>
	
	<div class="menu-detail-container">
		<form action="menu_detail_action.jsp" method="post">
			<table class="menu-table">
				<tr>
					<td rowspan="4">
						<img class="menu-img" alt="menu" src="./../images/<%=product_dto.getProductIMG() %>">
					</td>
				</tr>
				<tr>
					<th id="menu-name"><span class="menu-name-span"><%=product_dto.getProductNAME() %></span><br><hr class="hr_1"/></th>
				</tr>
				<tr>
					
					<td class="menu_detail-text"><%=product_dto.getProductPRICE() %>원</td>
				</tr>
				<tr>
					<td class="menu_detail-text"><%=product_dto.getProductINTRO() %></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>