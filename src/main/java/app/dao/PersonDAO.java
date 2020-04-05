package app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.dao.utils.DatabaseUtils;
import app.model.Account;
import app.model.Person;
import io.javalin.http.Context;

public class PersonDAO {
	public static final String SALT = "$2a$10$h.dl5J86rGH7I8bD9bZeZe";
    //public static List<Person> personList = new ArrayList<>();
	public static Person selectedPerson;

    public static boolean createPerson(String personname) {
    	List<Person> tempPersonList = new ArrayList<>();
    	try 
    	{
    		personname = checkForSingleQuote(personname);
    		String sql = "SELECT * FROM person WHERE fullname = '" + personname + "'";
    		
    		Connection connection = DatabaseUtils.connectToDatabase();
            Statement statement = connection.createStatement();
            ResultSet resultTest = statement.executeQuery(sql);
            ResultSet result = resultTest;

           while(result.next()) 
           {
           tempPersonList.add(new Person(result.getInt("person_id"), result.getString("fullname"),
        		   result.getString("role"), result.getDate("birthdate"), result.getString("bio")));
           }
           DatabaseUtils.closeConnection(connection);
    	}
        catch (Exception e) 
    	{
            e.printStackTrace();
        } 
    	
    	selectedPerson = tempPersonList.size() != 0 ? tempPersonList.get(0) : null;
    	
    	return tempPersonList.size() != 0;
    }
    
    public static Person getSelectedPerson() {
    	return selectedPerson;
    }
    
    //checks if the name has the single quote and changes string to be readable
    private static String checkForSingleQuote(String name) {
    	for(int i = 0; i < name.length(); i++) {
    		if(name.charAt(i) == '\'') {
    			String temp = name.substring(0, i) + "\\" + name.substring(i);
    			name = temp;
    			i++;
    		}
    	}
    	return name;
    }
}
