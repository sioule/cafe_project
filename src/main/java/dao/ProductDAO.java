package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.*;

public class ProductDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs;
	
	private String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	private String jdbc_url = "jdbc:mysql://mydbinstance.ctvgpvyuejsa.ap-northeast-2.rds.amazonaws.com:3306/myShoppingmallDB?serverTimezone=UTC";
	
	private String id = "shun04321";
	private String pw = "awstbs421!";
	
	public ProductDAO() {
		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, id, pw);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void ProductInsert(ProductDTO product) {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, id, pw);
			
			String sql = "insert into user values(?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, product.getProductID());
			pstmt.setString(2, product.getProductNAME());
			pstmt.setInt(3, product.getProductPRICE());
			pstmt.setInt(4, product.getProductSTOCK());
			pstmt.setString(5, product.getProductINTRO());
			pstmt.setString(6, product.getProductDATE());
			pstmt.setString(7, product.getProductIMG());
			
			int update = pstmt.executeUpdate();
			
			if(update == 0) System.out.println("DB 업데이트 실패");
			else System.out.println("DB 업데이트 성공");
		}
		catch(Exception e) {
			System.out.println(e);
		}finally{
			try{
				pstmt.close();
			}catch(Exception ignored){}
			try{
				conn.close();
			}catch(Exception ignored){}
		}
	}
}
	
	

