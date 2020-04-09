package app.model;

public class Image {
	// ATTRIBUTES
	private String folder;
	private String name;

	// CONSTRUCTOR
	Image(int id, boolean person) {
		folder = (person) ? "/img/people/" : "/img/shows/";
		name = id + ".jpg";
	}

	// TO STRING
	@Override
	public String toString() {
		return folder + name;
	}

}
