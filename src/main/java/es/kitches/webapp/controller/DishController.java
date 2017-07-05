package es.kitches.webapp.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.kitches.webapp.model.Dish;
import es.kitches.webapp.model.dto.DishDto;
import es.kitches.webapp.service.DishService;

@RequestMapping(path = "/api/v1/dishes")
@RestController(value = "dishesController")
public class DishController {

	@Autowired
	DishService dishService;
	
    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Dish> listAllDishes() throws SQLException {
    	return dishService.getAllAVailableDishes();
    }
    
    @RequestMapping(value="", method = RequestMethod.POST)
    public DishDto createDish(@RequestBody @Valid DishDto dish) throws SQLException {
    	return dishService.createDish(dish);
    }

    @RequestMapping(value="/{dishIdAsString}", method = RequestMethod.PUT)
    DishDto updateDish(@PathVariable String dishIdAsString, @RequestBody @Valid DishDto dish) throws SQLException {
    	dish.setId(Integer.valueOf(dishIdAsString));
    	return dishService.updateDish(dish);
	}
	
    @RequestMapping(value="/{dishIdAsString}", method = RequestMethod.DELETE)
	void deleteDish(@PathVariable String dishIdAsString) throws SQLException {
    	dishService.deleteDish(dishIdAsString);
	}

}
