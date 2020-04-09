package app.model;

import java.util.Date;

public class UserReview {
	// ATTRIBUTES
	private int reviewID;
	private String username;
	private String review;
	private int rating;
	private Date date;

	// CONSTRUCTOR
	public UserReview(String r, int v) {
		review = r;
		rating = v;
		date = new Date();
	}

	/*
	 * GETTERS
	 */
	public String getReview() {
		return review;
	}

	public Date getDate() {
		return date;
	}

	public int getRating() {
		return rating;
	}

	/*
	 * SETTERS
	 */
	public void setReview(String review) {
		this.review = review;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
