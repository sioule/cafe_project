<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% request.setCharacterEncoding("UTF-8"); %>
 <%@ page import="dao.ProductDAO"%>
<%@ page import="dto.ProductDTO"%>
<%@ page import="java.io.PrintWriter"%>
 <%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MENU</title>
<link href="./../css/index.css" rel="stylesheet" type="text/css" />
<link href="./../css/product.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./../js/product.js"></script>
</head>
<body>

<!-- 정민지 -->
	<%
		ProductDTO dto = new ProductDTO();
		ProductDAO dao = new ProductDAO();
	
		ArrayList<ProductDTO> dessertList =  dao.getdessertASC();// 가격 낮은순 정렬
	%>
	
	<div class="menu-container">
		
		<h2 class="coffee-text">
			-Dessert
		</h2>
		<select name="sort"  onchange="sort(this.value);">	
			<option name="selected-sort">정렬선택</option>
			<option name="sort-asc" value="dessert_asc">낮은가격순</option>
			<option name="sort-desc" value="dessert_desc">높은가격순</option>
		</select>	
		
		<ul class="coffee-outer">
		
			<%
				for(ProductDTO menu : dessertList){
			%>

			<li class="coffee-inner">
				<div class="coffee">
					<a href="./../product/menu_detail.jsp?product_id=<%=menu.getProductID()%>"><img alt="menu" src="./../images/<%=menu.getProductIMG() %>"></a><br>
					<%=menu.getProductNAME() %><br>
					<%=menu.getProductPRICE() %>
				</div>
			</li>
			
			<%} %>		
		</ul>
	</div>
</body> 
</html>