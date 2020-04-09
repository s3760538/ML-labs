package app.model;

import java.util.List;

public class Show {
	// ATTRIBUTES
	private int showid;
	private String showTitle;
	private double length;
	private boolean isMovie;
	private boolean isSeries;
	private String genre;
	private int proco_id;
	private int year;
	private Image photo;

	private List<UserReview> userReviewList;
	private ProductionCompany productionCompany;

	private List<CreditsRoll> creditsRolls;

	// CONSTRUCTOR
	public Show(int showid, String showTitle, String genre, double length, boolean isMovie, boolean isSeries,
			int proco_id, int year) {
		this.showid = showid;
		this.showTitle = showTitle;
		this.genre = genre;
		this.length = length;
		this.isMovie = isMovie;
		this.isSeries = isSeries;
		this.proco_id = proco_id;
		this.year = year;
		photo = new Image(showid, false);
	}

	// TO STRING
	@Override
	public String toString() {
		return String.format(
				"Show ID: %s\n" + "Show Title: %s\n" + "Genre: %s\n" + "Length: %s\n" + "Movie/Series: %s\n"
						+ "Proco_ID: %s\n" + "Year: %s\n",
				getShowID(), getShowTitle(), getGenre(), getLength(), getType(), getProcoId(), getYear());
	}

	// return the type of show
	public String type() {
		String type = "";

		if (this.isMovie == true) {
			type = "Movie";
		} else if (this.isSeries == true) {
			type = "Series";
		}

		return type;
	}

	/*
	 * GETTERS
	 */
	public int getShowID() {
		return this.showid;
	}

	public String getShowTitle() {
		return this.showTitle;
	}

	public String getGenre() {
		return genre;
	}

	public double getLength() {
		return this.length;
	}

	public String getType() {
		return type();
	}

	public int getProcoId() {
		return proco_id;
	}

	public int getYear() {
		return this.year;
	}

	public Image getPhoto() {
		return photo;
	}

	public String getAllInfo() {
		return "Length: " + getLength() + "\n" + "Genre: " + getGenre() + "\n" + "Year: " + getYear();
	}
}
