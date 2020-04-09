package app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.dao.utils.DatabaseUtils;
import app.model.Account;


/*
 * Account Class
 */
public class AccountDAO {
	
	//VARIABLES:
	//password encryption constant
    public static final String SALT = "$2a$10$h.dl5J86rGH7I8bD9bZeZe";
    //list of accounts
    public static List<Account> accountList = new ArrayList<>();
   

    /**
     * Method to fetch users from the database.
     * You should use this as an example for future queries, though the sql statement
     * will change -and you are supposed to write them.
     *
     * Current user: caramel 6, password (the password is "password" without quotes)
     * @param username what the user typed in the log in form.
     * @return Some of the user data to check on the password. Null if there
     *         no matching user.
     */
    public static Account getUserByUsername(String username) {
        //Copy of accounts
        List<Account> accounts = new ArrayList<>();

        try {
        	
            //Select Account SQL query
            String sql = "SELECT * "
            		+ "FROM account WHERE lower(username) ='" + username.toLowerCase() + "'";

            // Execute SQL query
            Connection connection = DatabaseUtils.connectToDatabase();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            // If multiple results, do WHILE
            while(result.next()) {
                // 2) Add each result to account list
                accounts.add(
                  // 1) Create new account object
                  new Account(
                  result.getString("username"),
                  result.getString("password"),
                  result.getString("email"),
                  result.getString("country"),
                  result.getString("gender"),
                  result.getString("first_name"),
                  result.getString("last_name")
                  )
                );
            }
            accountList.add(accounts.get(0));
            // Close DB connection
            DatabaseUtils.closeConnection(connection);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // If account found, return account
        if(!accounts.isEmpty()) return accounts.get(0);
        // No account found, return null
        return null;
    }
    
    //return account at specific index
    public static Account accessAcount(int index) {
    	return accountList.get(index);
    }
}
