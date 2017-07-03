package es.kitches.webapp.model;

public class Dish {

	private int id;
	private String imageUrl;
	private String dishName;
	private String chefId;
	private String chefName;
	private String averageRating;
	private String numberOfRatings;
	private String numberOfComments;
	private String availablePortions;
	private String price;
	
	public Dish(int id, String imageUrl, String dishName, String chefId, String chefName, String averageRating,
			String numberOfRatings, String numberOfComments, String availablePortions, String price) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.dishName = dishName;
		this.chefId = chefId;
		this.chefName = chefName;
		this.averageRating = averageRating;
		this.numberOfRatings = numberOfRatings;
		this.numberOfComments = numberOfComments;
		this.availablePortions = availablePortions;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getChefId() {
		return chefId;
	}

	public void setChefId(String chefId) {
		this.chefId = chefId;
	}

	public String getChefName() {
		return chefName;
	}

	public void setChefName(String chefName) {
		this.chefName = chefName;
	}

	public String getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}

	public String getNumberOfRatings() {
		return numberOfRatings;
	}

	public void setNumberOfRatings(String numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	public String getNumberOfComments() {
		return numberOfComments;
	}

	public void setNumberOfComments(String numberOfComments) {
		this.numberOfComments = numberOfComments;
	}

	public String getAvailablePortions() {
		return availablePortions;
	}

	public void setAvailablePortions(String availablePortions) {
		this.availablePortions = availablePortions;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
