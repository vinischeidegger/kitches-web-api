package es.kitches.webapp.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.kitches.webapp.dao.DBConnection;
import es.kitches.webapp.model.Dish;
import es.kitches.webapp.service.DishService;

@Service("dishService")
public class DishServiceImpl implements DishService {

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

		try {
			PreparedStatement ps = conn.getConn().prepareStatement(sql);
		
		    ResultSet rs = ps.executeQuery();
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
		}
		finally{
			
		}
    	
		return dishes;
	}

}
