package es.kitches.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.kitches.webapp.model.Dish;

@Service("dishService")
public interface DishService {
	
	public List<Dish> getAllAVailableDishes();

}
