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
/*
 * Person Class
 */
public class PersonDAO {
	// VARIABLES:
	// password encryption constant
	public static final String SALT = "$2a$10$h.dl5J86rGH7I8bD9bZeZe";
	// currently selected person object
	public static Person selectedPerson;

	// CREATE PERSON METHOD
	public static boolean createPerson(String personname) {
		// list of people
		List<Person> tempPersonList = new ArrayList<>();

		// check
		try {
			// find the person in SQL database (not case sensitive)
			personname = checkForSingleQuote(personname);
			String sql = "SELECT * FROM person WHERE lower(fullname) = '" + personname.toLowerCase() + "'";

			// connection to database created
			Connection connection = DatabaseUtils.connectToDatabase();
			Statement statement = connection.createStatement();
			ResultSet resultTest = statement.executeQuery(sql);
			ResultSet result = resultTest;
			// 1) while there is still another result in the set
			while (result.next()) {
				// 2) add the person to the person list
				tempPersonList.add(new Person(result.getInt("person_id"), result.getString("fullname"),
						result.getString("role"), result.getDate("birthdate"), result.getString("bio")));
			}
			// close DB connection
			DatabaseUtils.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// assign the first person of the arraylist as the selected
		// else return null
		selectedPerson = tempPersonList.size() != 0 ? tempPersonList.get(0) : null;
		// return there is a person who fits the criteria (Return an arraylist length of
		// greater than 0)
		return tempPersonList.size() != 0;
	}

	// getter
	public static Person getSelectedPerson() {
		return selectedPerson;
	}

	// checks if name has single quotes and changes string to be readable
	private static String checkForSingleQuote(String name) {
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == '\'') {
				String temp = name.substring(0, i) + "\\" + name.substring(i);
				name = temp;
				i++;
			}
		}
		return name;
	}
}
