package es.kitches.webapp.model;

public class Rating {

	private int ratingId;
	private int dishId;
	private int userId;
	private String userName;
	private double stars;
	private String comment;
	
	public Rating(int ratingId, int dishId, int userId, String userName, double stars, String comment) {
		super();
		this.ratingId = ratingId;
		this.dishId = dishId;
		this.userId = userId;
		this.userName = userName;
		this.stars = stars;
		this.comment = comment;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
