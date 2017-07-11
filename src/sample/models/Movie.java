package sample.models;

/**
 * Created by d.buetikofer on 05.07.2017.
 */
public class Movie {

    /**
     * Movie Title
     */
    private String title;

    /**
     * Movie Description
     */
    private String description;

    /**
     * Default Constructor
     * @param title
     * @param description
     */
    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
