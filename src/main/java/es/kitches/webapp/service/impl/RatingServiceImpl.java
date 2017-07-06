package es.kitches.webapp.service.impl;

import java.io.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.kitches.webapp.dao.DBConnection;
import es.kitches.webapp.model.dto.RatingDto;
import es.kitches.webapp.service.RatingService;

@Service("ratingService")
public class RatingServiceImpl implements RatingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RatingServiceImpl.class);
	@Autowired
	private DBConnection conn;
	
	@Override
	public RatingDto createRating(RatingDto rating) {
    	
		String sql = "INSERT INTO kitches.dish_ratings (dish_id, user_id, stars, comment) VALUES (?,?,?,?)";

		try (PreparedStatement ps = conn.getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
			ps.setInt(1, rating.getDishId());
			ps.setInt(2, rating.getUserId());
			ps.setDouble(3, rating.getStars());
			ps.setString(4, rating.getComment());
			

			ps.executeUpdate();
			ResultSet rsId = ps.getGeneratedKeys();
			rsId.next();
			int auto_id = rsId.getInt(1);
			
			String sqlQuery = "SELECT r.rating_id FROM kitches.dish_ratings r where rating_id = ?";
			PreparedStatement ps1 = conn.getConn().prepareStatement(sqlQuery);
			ps1.setInt(1, auto_id);
			ResultSet rs = ps1.executeQuery();
		    
		    if (rs.next()) {
		    	rating.setRatingId(rs.getInt("rating_id"));
		    }
		    rs.close();
			ps.close();
		}
		catch(SQLException e){
			LOGGER.error(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		finally{
			
		}
    	
		return rating;
	}
}
