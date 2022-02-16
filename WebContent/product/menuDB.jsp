<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dto.ProductDTO" %>
<%@ page import="dao.ProductDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
		try{
			request.setCharacterEncoding("utf-8");
			ProductDTO user_dto = new ProductDTO();
			ProductDAO user_dao = new ProductDAO();
			String user_id = request.getParameter("product_id");
			String user_pwd = request.getParameter("product_id");
			String user_name = request.getParameter("name");
		
			String user_phone1 = request.getParameter("phone1");
			String user_phone2 = request.getParameter("phone2");
			String user_phone3 = request.getParameter("phone3");
			String user_phonenum = user_phone1 + user_phone2 + user_phone3;
		
			String user_email = request.getParameter("email");
		
			String user_addr1 = request.getParameter("addr1");
			String user_addr2 = request.getParameter("addr2");
			String user_addr3 = request.getParameter("addr3");
			String user_address = user_addr1 + " " + user_addr2 + " " + user_addr3;
		
		
		}catch(Exception e){
			System.out.println(e);
		}
	%>

</body>
</html>