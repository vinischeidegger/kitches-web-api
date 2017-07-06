package es.kitches.webapp.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.kitches.webapp.model.dto.RatingDto;
import es.kitches.webapp.service.RatingService;

@RequestMapping(path = "/api/v1/rating")
@RestController(value = "ratingController")
public class RatingController {

	@Autowired
	RatingService ratingService;
	
    @RequestMapping(value="", method = RequestMethod.POST)
    public RatingDto createDish(@RequestBody @Valid RatingDto rating) throws SQLException {
    	return ratingService.createRating(rating);
    }

}
