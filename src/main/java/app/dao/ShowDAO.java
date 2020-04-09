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
    public static Show selectedShow;
    
    public static boolean createShow(String showName) { 
    	 // Fish out the results
        List<Show> shows = new ArrayList<>();
        
        try {
            // Here you prepare your sql statement
            String sql = "SELECT * FROM imbd.show WHERE show_title = '" + showName + "'";

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
                  result.getString("genre"),
                  result.getDouble("length"),
                  result.getBoolean("movie"), 
                  result.getBoolean("series"),
                  result.getInt("proco_id"), 
                  result.getInt("year")
                  )
                );
            }
            // Close it
            DatabaseUtils.closeConnection(connection);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        selectedShow = shows.size() != 0 ? shows.get(0) : null;
        
    	return shows.size() != 0;
    }
    
    public static Show getSelectedShow() {
    	return selectedShow;
    }
    
}
