package es.kitches.webapp.service;

import org.springframework.stereotype.Service;

import es.kitches.webapp.model.dto.RatingDto;

@Service("dishService")
public interface RatingService {

	RatingDto createRating(RatingDto dish);

}
