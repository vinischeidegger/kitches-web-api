package es.kitches.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.kitches.webapp.model.Dish;
import es.kitches.webapp.service.DishService;

@RequestMapping(path = "/api/v1/dishes")
@RestController(value = "dishesController")
public class DishController {

	@Autowired
	DishService dishService;
	
    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Dish> listAllDishes() {
    	return dishService.getAllAVailableDishes();
    }
    
	@RequestMapping(value="/{userName}", method = RequestMethod.GET)
	String home(@PathVariable String userName) {
		return "Hello " + userName + "!";
	}
	
    @RequestMapping(value="/secure", method = RequestMethod.GET)
    public String secureGeneralHello() {
    	return "Hello";
    }
    
	@RequestMapping(value="/secure/{userName}", method = RequestMethod.GET)
	String secureHello(@PathVariable String userName) {
		return "Hello " + userName + "!";
	}

}
