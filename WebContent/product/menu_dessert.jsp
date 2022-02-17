<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="dao.ProductDAO"%>
<%@ page import="dto.ProductDTO"%>
<%@ page import="java.io.PrintWriter"%>
 <%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		ProductDTO dto = new ProductDTO();
		ProductDAO dao = new ProductDAO();
	
		ArrayList<ProductDTO> listOfProducts =  dao.getProducts_dessertlist();
	%>
	
	<div class="container">
		<div class="row" align="center">
			<%
				for(int i=0; i<listOfProducts.size(); i++){
					ProductDTO product = listOfProducts.get(i);
			%>
			
			<div class="col-md-4">
				
			<a href=""><img alt="menu" src="./../images/<%=product.getProductIMG() %>"></a><P>
				
			<h3><%=product.getProductNAME() %></h3>
			</div>
			
			<%
				}
			%>
		</div>
		
		<hr>
	</div>

	

</body>
</html>
