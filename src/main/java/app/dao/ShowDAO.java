package app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.dao.utils.DatabaseUtils;
import app.model.Show;

public class ShowDAO
{
    public static List<Show> showList = new ArrayList<>();

    
    public static Show getShowByShowName(String showName) { 
    	 // Fish out the results
        List<Show> shows = new ArrayList<>();
        
        try {
            // Here you prepare your sql statement
            String sql = "SELECT * "
            		+ "FROM show WHERE show_title ='" + showName + "'";

            // Execute the query
            Connection connection = DatabaseUtils.connectToDatabase();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            // If you have multiple results, you do a while
            while(result.next()) {
                // 2) Add it to the list we have prepared
                shows.add(
                  // 1) Create a new show object
                  new Show(
                  result.getInt("showid"),
                  result.getString("show_title"),
                  result.getDouble("length"),
                  result.getBoolean("movie"), 
                  result.getBoolean("series"),
                  result.getString("genre"), 
                  result.getInt("year")
                  )
                );
            }
            System.out.println(shows.get(0).toString());
            showList.add(shows.get(0));
            // Close it
            DatabaseUtils.closeConnection(connection);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    	
    	// If there is a result
        if(!shows.isEmpty()) return shows.get(0);
        // If we are here, something bad happened
        return null;
    }
    
    public static Show accessShow(int index) {
    	return showList.get(index);
    }
    
}
