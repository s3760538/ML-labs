package app.model;

public class CreditsRoll {
	// ATTRIBUTES
	private Person person;
	private String role;
	private String character;
	private int startYear;
	private int endYear;

	//CONSTRUCTOR
	public CreditsRoll(Person person, String role, int startYear) {
		this.person = person;
		this.role = role;
		this.startYear = startYear;
	}

	/*
	 * GETTERS
	 */
	public Person getPerson() {
		return person;
	}

	public String getRole() {
		return role;
	}

	public int getStartYear() {
		return startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public String getCharacter() {
		return character;
	}

	/*
	 * SETTERS
	 */
	public void setCharacter(String character) {
		this.character = character;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
}
