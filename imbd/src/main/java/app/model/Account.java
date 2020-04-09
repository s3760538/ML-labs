package app.model;

public class Account {
	// ATTRIBUTES
	private String firstName;
	private String lastName;
	private String address;
	private String username;

	/**
	 * Only stores hashed passwords.
	 */
	private String password;

	private String country;
	private String gender;
	private String email;

	// CONSTRUCTOR #1
	public Account(String un, String p) {
		username = un;
		password = p;
	}

	// CONSTRUCTOR #2
	public Account(String username, String password, String email, String country, String gender, String firstName,
			String lastName) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.country = country;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	// to string
	@Override
	public String toString() {
		return String.format(
				"Username: %s\n" + "Password: %s\n" + "Email: %s\n" + "Country: %s\n" + "Gender: %s\n"
						+ "FirstName: %s\n" + "LastName: %s\n",
				this.username, this.password, this.email, this.country, this.gender, this.firstName, this.lastName);
	}

	// SETTERS
	public void updateDetails() {
		// TODO
	}

	/*
	 *  GETTERS
	 */
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
