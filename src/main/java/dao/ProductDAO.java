package dao;

import java.sql.*;
import java.util.*;

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
			
			String sql = "insert into product values(?, ?, ?, ?, ?, ?, (now()), ?)";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, product.getProductID());
			pstmt.setString(2, product.getProductNAME());
			pstmt.setString(3, product.getProductCATEGORY());
			pstmt.setInt(4, product.getProductPRICE());
			pstmt.setInt(5, product.getProductSTOCK());
			pstmt.setString(6, product.getProductINTRO());
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
	
	public ArrayList<ProductDTO> getProductCoffeeList(){
        

        ArrayList<ProductDTO> coffeeList = new ArrayList<ProductDTO>();

        try {
    		Class.forName(jdbc_driver);
    		conn = DriverManager.getConnection(jdbc_url, id, pw);
    		
            String sql = "select * from product where product_category='coffee'";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                ProductDTO product = new ProductDTO();

                product.setProductID(rs.getInt("product_id"));
                product.setProductNAME(rs.getString("product_name"));
                product.setProductCATEGORY(rs.getString("product_category"));
                product.setProductPRICE(rs.getInt("product_price"));
                product.setProductSTOCK(rs.getInt("product_stock"));
                product.setProductINTRO(rs.getString("product_intro"));
                product.setProductIMG(rs.getString("product_img"));

                coffeeList.add(product);
            }
            rs.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return coffeeList;
    }
	
	public ArrayList<ProductDTO> getProducts_dessertlist() { //상품목록

		ArrayList<ProductDTO> dessertList = new ArrayList<ProductDTO>();
		try {
			
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, id, pw);
			
			String sql = "SELECT * FROM product where product_category='dessert'";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {

			ProductDTO product = new ProductDTO();
			
			product.setProductID(rs.getInt("product_id"));
			product.setProductNAME(rs.getString("product_name"));
			product.setProductCATEGORY(rs.getString("product_category"));
			product.setProductPRICE(rs.getInt("product_price"));
			product.setProductSTOCK(rs.getInt("product_stock"));
			product.setProductINTRO(rs.getString("product_intro"));
			product.setProductIMG(rs.getString("product_img"));
			
			dessertList.add(product);
		
			}
		rs.close();

	}catch (Exception e) {
        System.out.println(e);
	}
   
	return dessertList;

	}
	
	
	
	public ProductDTO getProduct(int product_id){ 
        

		String sql = "select * from product where product_id=?";
        ProductDTO product = new ProductDTO();
        try {
    		Class.forName(jdbc_driver);
    		conn = DriverManager.getConnection(jdbc_url, id, pw);

            pstmt = conn.prepareStatement(sql);
           
            pstmt.setInt(1, product_id);
            rs = pstmt.executeQuery();
            rs.next();

           product.setProductID(rs.getInt("product_id"));
           product.setProductNAME(rs.getString("product_name"));
           product.setProductCATEGORY(rs.getString("product_category"));
           product.setProductPRICE(rs.getInt("product_price"));
           product.setProductSTOCK(rs.getInt("product_stock"));
           product.setProductINTRO(rs.getString("product_intro"));
           product.setProductIMG(rs.getString("product_img"));
            
            rs.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        
        return product;
    }
	
	
		public ArrayList<ProductDTO> getCoffeeDESC(){//coffee 높은 가격순
	        
	
	        ArrayList<ProductDTO> coffeeDESC = new ArrayList<ProductDTO>();
	
	        try {
	    		Class.forName(jdbc_driver);
	    		conn = DriverManager.getConnection(jdbc_url, id, pw);
	    		
	            String sql = "select * from product where product_category='coffee' order by product_price desc";
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	
	            while(rs.next()) {
	                ProductDTO product = new ProductDTO();
	
	                product.setProductID(rs.getInt("product_id"));
	                product.setProductNAME(rs.getString("product_name"));
	                product.setProductCATEGORY(rs.getString("product_category"));
	                product.setProductPRICE(rs.getInt("product_price"));
	                product.setProductSTOCK(rs.getInt("product_stock"));
	                product.setProductINTRO(rs.getString("product_intro"));
	                product.setProductIMG(rs.getString("product_img"));
	
	                coffeeDESC.add(product);
	            }
	            rs.close();
	        }catch (Exception e) {
	            System.out.println(e);
	        }
	        return coffeeDESC;
	    }
		
		public ArrayList<ProductDTO> getdessertDESC() { //dessert 높은 가격순
	
			ArrayList<ProductDTO> desserDESC = new ArrayList<ProductDTO>();
			try {
				
				Class.forName(jdbc_driver);
				conn = DriverManager.getConnection(jdbc_url, id, pw);
				
				String sql = "select * from product where product_category='dessert' order by product_price desc";
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
	
				while(rs.next()) {
	
				ProductDTO product = new ProductDTO();
				
				product.setProductID(rs.getInt("product_id"));
				product.setProductNAME(rs.getString("product_name"));
				product.setProductCATEGORY(rs.getString("product_category"));
				product.setProductPRICE(rs.getInt("product_price"));
				product.setProductSTOCK(rs.getInt("product_stock"));
				product.setProductINTRO(rs.getString("product_intro"));
				product.setProductIMG(rs.getString("product_img"));
				
				desserDESC.add(product);
			
				}
			rs.close();
	
		}catch (Exception e) {
	        System.out.println(e);
		}
	   
		return desserDESC;
	
		}
		
		public ArrayList<ProductDTO> getCoffeeASC(){//coffee 낮은 가격순
	        
			
	        ArrayList<ProductDTO> coffeeASC = new ArrayList<ProductDTO>();
	
	        try {
	    		Class.forName(jdbc_driver);
	    		conn = DriverManager.getConnection(jdbc_url, id, pw);
	    		
	            String sql = "select * from product where product_category='coffee' order by product_price";
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	
	            while(rs.next()) {
	                ProductDTO product = new ProductDTO();
	
	                product.setProductID(rs.getInt("product_id"));
	                product.setProductNAME(rs.getString("product_name"));
	                product.setProductCATEGORY(rs.getString("product_category"));
	                product.setProductPRICE(rs.getInt("product_price"));
	                product.setProductSTOCK(rs.getInt("product_stock"));
	                product.setProductINTRO(rs.getString("product_intro"));
	                product.setProductIMG(rs.getString("product_img"));
	
	                coffeeASC.add(product);
	            }
	            rs.close();
	        }catch (Exception e) {
	            System.out.println(e);
	        }
	        return coffeeASC;
	    }
		
		public ArrayList<ProductDTO> getdessertASC() { //dessert 낮은 가격순
	
			ArrayList<ProductDTO> dessertASC = new ArrayList<ProductDTO>();
			try {
				
				Class.forName(jdbc_driver);
				conn = DriverManager.getConnection(jdbc_url, id, pw);
				
				String sql = "select * from product where product_category='dessert' order by product_price";
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
	
				while(rs.next()) {
	
				ProductDTO product = new ProductDTO();
				
				product.setProductID(rs.getInt("product_id"));
				product.setProductNAME(rs.getString("product_name"));
				product.setProductCATEGORY(rs.getString("product_category"));
				product.setProductPRICE(rs.getInt("product_price"));
				product.setProductSTOCK(rs.getInt("product_stock"));
				product.setProductINTRO(rs.getString("product_intro"));
				product.setProductIMG(rs.getString("product_img"));
				
				dessertASC.add(product);
			
				}
			rs.close();
	
		}catch (Exception e) {
	        System.out.println(e);
		}
	   
		return dessertASC;
	
		}
		
	
}
	
	

