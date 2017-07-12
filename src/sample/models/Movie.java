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

    private String imageFile;

    /**
     * Default Constructor
     *
     * @param title
     * @param description
     */
    public Movie(String title, String description, String imageFile) {
        this.title = title;
        this.description = description;
        this.imageFile = imageFile;
    }

    public Movie(){
        this.title = "";
        this.description = "";
        this.imageFile = "";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageFile() {
        return this.imageFile;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
}
