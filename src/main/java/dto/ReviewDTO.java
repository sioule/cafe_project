package dto;

import java.sql.Timestamp;

public class ReviewDTO {
	private int reviewID;
	private int review_orderID;
	private int review_productID;
	private String userID;
	private String review_content;
	private int grade;
	private Timestamp date;
	private String productName;
	public int getReviewID() {
		return reviewID;
	}
	public int getReview_orderID() {
		return review_orderID;
	}
	public int getReview_productID() {
		return review_productID;
	}
	public String getUserID() {
		return userID;
	}
	public String getReview_content() {
		return review_content;
	}
	public int getGrade() {
		return grade;
	}
	public Timestamp getDate() {
		return date;
	}
	public String getProductName() {
		return productName;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public void setReview_orderID(int review_orderID) {
		this.review_orderID = review_orderID;
	}
	public void setReview_productID(int review_productID) {
		this.review_productID = review_productID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	
}