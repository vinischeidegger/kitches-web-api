package es.kitches.webapp.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DishDto {

	private int id;
    @NotNull(message = "You must provide a valid Dish Name")
    @Size(min = 1, max = 45, message = "Dish Name must contain at least 1 character and not exceed 45 characters")
    private String dishName;
	private String description;
	private String imageUrl;
	private int chefId = -1;
	private int availablePortions = -1;
	private double price = -1;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getChefId() {
		return chefId;
	}
	public void setChefId(int chefId) {
		this.chefId = chefId;
	}
	public int getAvailablePortions() {
		return availablePortions;
	}
	public void setAvailablePortions(int availablePortions) {
		this.availablePortions = availablePortions;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "DishDto [id=" + id + ", dishName=" + dishName + ", description=" + description + ", imageUrl="
				+ imageUrl + ", chefId=" + chefId + ", availablePortions=" + availablePortions + ", price=" + price
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availablePortions;
		result = prime * result + chefId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dishName == null) ? 0 : dishName.hashCode());
		result = prime * result + id;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DishDto other = (DishDto) obj;
		if (availablePortions != other.availablePortions)
			return false;
		if (chefId != other.chefId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dishName == null) {
			if (other.dishName != null)
				return false;
		} else if (!dishName.equals(other.dishName))
			return false;
		if (id != other.id)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	
}
