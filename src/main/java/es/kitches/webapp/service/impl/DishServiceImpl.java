package es.kitches.webapp.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.kitches.webapp.dao.DBConnection;
import es.kitches.webapp.model.Dish;
import es.kitches.webapp.model.dto.DishDto;
import es.kitches.webapp.service.DishService;

@Service("dishService")
public class DishServiceImpl implements DishService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DishServiceImpl.class);
	@Autowired
	private DBConnection conn;
	
	@Override
	public List<Dish> getAllAVailableDishes() {

    	List<Dish> dishes = new ArrayList<Dish>();
    	
		String sql = "SELECT  d.id, " +
					"		d.dishName, " +
					"		d.dishImageUrl, " +
					"		d.chefId, " +
					"		c.chefName, " +
					"        AVG(r.stars) stars, " +
					"        SUM(CASE WHEN r.rating_id IS NULL THEN 0 ELSE 1 END) rating_qty, " +
					"        SUM(CASE WHEN r.comment IS NULL OR trim(r.comment) = '' THEN 0 ELSE 1 END) comment_qty, " +
					"        d.availablePortions, " +
					"        d.price " +
					"FROM kitches.dish d " +
					"join kitches.chef c " +
					"on d.chefId = c.id " +
					"LEFT join kitches.dish_ratings r " +
					"on d.id = r.dish_id " +
					"group by d.id, " +
					"		d.dishName, " +
					"		d.chefId, " +
					"		c.chefName";

		try (PreparedStatement ps = conn.getConn().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();){
		
		    while (rs.next()) {
		    	
		    	Dish newDish = new Dish(rs.getInt("id"), rs.getString("dishImageUrl"),
		    			rs.getString("dishName"), rs.getString("chefId"), rs.getString("chefName"),
		    			String.valueOf(rs.getDouble("stars")), rs.getString("rating_qty"),
		    			rs.getString("comment_qty"), rs.getString("availablePortions"), rs.getString("price"));
		    	dishes.add(newDish);
		    }
		    rs.close();
			ps.close();
		}
		catch(SQLException e){
			LOGGER.error(e.getMessage());
		}
		finally{
			
		}
    	
		return dishes;
	}

	@Override
	public DishDto createDish(DishDto dish) throws SQLException {
    	
		String sql = "INSERT INTO kitches.dish (dishName, dishImageUrl, dishDescription, chefId, availablePortions, price) VALUES (?,?,?,?,?,?)";

		try (PreparedStatement ps = conn.getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
			ps.setString(1, dish.getDishName());
			ps.setString(2, dish.getImageUrl());
			ps.setString(3, dish.getDescription());
			ps.setInt(4, dish.getChefId());
			ps.setInt(5, dish.getAvailablePortions());
			ps.setDouble(6, dish.getPrice());

			ps.executeUpdate();
			ResultSet rsId = ps.getGeneratedKeys();
			rsId.next();
			int auto_id = rsId.getInt(1);
			
			String sqlQuery = "SELECT d.id FROM kitches.dish d where id = ?";
			PreparedStatement ps1 = conn.getConn().prepareStatement(sqlQuery);
			ps1.setInt(1, auto_id);
			ResultSet rs = ps1.executeQuery();
		    
		    if (rs.next()) {
		    	dish.setId(rs.getInt("id"));
		    }
		    rs.close();
			ps.close();
		}
		catch(SQLException e){
			LOGGER.error(e.getMessage());
			throw e;
		}
		finally{
			
		}
    	
		return dish;
	}

	@Override
	public DishDto updateDish(DishDto dish) throws SQLException {
		
		DishDto foundDish = new DishDto();
		
		String sql = "UPDATE kitches.dish  SET dishName = ?, dishImageUrl = ?, dishDescription = ?, chefId = ?, availablePortions = ?, price = ? where id = ?";
		try (PreparedStatement ps = conn.getConn().prepareStatement(sql);){
			ps.setString(1, dish.getDishName());
			ps.setString(2, dish.getImageUrl());
			ps.setString(3, dish.getDescription());
			ps.setInt(4, dish.getChefId());
			ps.setInt(5, dish.getAvailablePortions());
			ps.setDouble(6, dish.getPrice());
			ps.setInt(7, dish.getId());

			ps.executeUpdate();
			foundDish = findDishById(dish.getId());
			
		}
		catch(SQLException e){
			LOGGER.error(e.getMessage());
			throw e;
		}
		finally{
			
		}
    	
		
		return foundDish;
	}

	@Override
	public void deleteDish(String dishIdAsString) {
		String sql = "DELETE FROM kitches.dish d " +
				"WHERE d.id = ?";
		try {
			PreparedStatement ps = conn.getConn().prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(dishIdAsString));
		    ps.executeQuery();
		}
		catch(SQLException e){
			LOGGER.error(e.getMessage());
		}
		finally{
			
		}
	}
	
	public DishDto findDishById(int dishId) {
		
		DishDto dish = new DishDto();
		
		String sql = "SELECT  d.id, " +
				"		d.dishName, " +
				"		d.dishDescription, " +
				"		d.dishImageUrl, " +
				"		d.chefId, " +
				"       d.availablePortions, " +
				"       d.price " +
				"FROM kitches.dish d " +
				"WHERE d.id = ?";

		try {
			PreparedStatement ps = conn.getConn().prepareStatement(sql);
			ps.setInt(1, dishId);
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) {
		    	
		    	dish.setId(rs.getInt("id"));
		    	dish.setImageUrl(rs.getString("dishImageUrl"));
		    	dish.setDishName(rs.getString("dishName"));
		    	dish.setDescription(rs.getString("dishDescription"));
		    	dish.setChefId(rs.getInt("chefId"));
		    	dish.setAvailablePortions(rs.getInt("availablePortions"));
		    	dish.setPrice(rs.getDouble("price"));
		    	
		    }
		    rs.close();
			ps.close();
		}
		catch(SQLException e){
			LOGGER.error(e.getMessage());
		}
		finally{
			
		}
		
		return dish;
	}

}
