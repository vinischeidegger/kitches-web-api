package es.kitches.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.kitches.webapp.model.Dish;
import es.kitches.webapp.model.Rating;
import es.kitches.webapp.model.dto.DishDto;

@Service("dishService")
public interface DishService {
	
	public List<Dish> getAllAVailableDishes();

	public DishDto createDish(DishDto dish);

	public DishDto updateDish(DishDto dish);

	public void deleteDish(String dishIdAsString);

	public List<Rating> getAllRatingForDish(String dishIdAsString);

}
