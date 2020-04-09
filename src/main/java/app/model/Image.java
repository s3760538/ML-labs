package app.model;




public class Image {
    private String folder;
    private String name;



    Image(int id, boolean person) {
        folder = (person) ? "/img/people/" : "/img/shows/";
        name = id + ".jpg";
    }

    @Override
    public String toString() {
    	return folder + name;
    }


}
