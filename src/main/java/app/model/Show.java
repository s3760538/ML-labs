package app.model;


import java.util.List;


public class Show {
    private int showid;
    private String showTitle;
    private double length;
    private boolean isMovie;
    private boolean isSeries;
    private String genre;
    private int year;

    private List<UserReview> userReviewList;
    private ProductionCompany productionCompany;

    private List<CreditsRoll> creditsRolls;

    public Show(int showid, String showTitle, double length, boolean isMovie, boolean isSeries,
    		String genre, int year) 
    {
    	this.showid = showid;
    	this.showTitle = showTitle;
    	this.length = length;
    	this.isMovie = isMovie;
    	this.isSeries = isSeries;
    	this.genre = genre;
    	this.year = year;
    }

    @Override
    public String toString() {
    	return String.format(
    	"Show ID: %s\n" +
    	"Show Title: %s\n" +
    	"Length: %s\n" +
    	"Movie/Series: %s\n" +
    	"Genre: %s\n" +
    	"Year: %s\n",
    	getShowID(), getShowTitle(), getLength(), 
    	getType(), getGenre(), getYear()
    	);
    }
    
    public String type() {
    	String type = "";
    	
    	if (this.isMovie == true) {
    		type = "Movie";
    	} else if (this.isSeries == true) {
    		type = "Series";
    	}
    	
    	return type;
    }
    
    public int getShowID() {
    	return this.showid;
    }
    
    public String getShowTitle() {
    	return this.showTitle;
    }
    
    public double getLength() {
    	return this.length;
    }
    
    public String getType() {
    	return type();
    }
    
    public String getGenre() {
    	return genre;
    }

    public int getYear() {
    	return this.year;
    }
}
