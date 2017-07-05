package es.kitches.webapp.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import es.kitches.webapp.model.Dish;
import es.kitches.webapp.model.dto.DishDto;

@Service("dishService")
public interface DishService {
	
	public List<Dish> getAllAVailableDishes() throws SQLException;

	public DishDto createDish(DishDto dish) throws SQLException;

	public DishDto updateDish(DishDto dish) throws SQLException;

	public void deleteDish(String dishIdAsString) throws SQLException;

}
