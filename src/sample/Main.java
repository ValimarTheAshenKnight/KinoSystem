package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.models.Movie;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.List;

public class Main extends Application {


    private Stage MovieBildschirm;

    private Stage MovieDescription;

    private List<Movie> moviesList;

    private TextArea textDisplay;

    private Stage Hall;

    private Stage Admin;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.moviesList = new ArrayList<>();
        moviesList.add(new Movie("Blue-Eyes Chaos Max Dragon", "The Struggle of humanity\nagainst the Titular \nBlue-Eyes Chaos Max Dragon. \nWill humanity be able to emerge \nvictorious against this near \ngodlike creature!?", "BlueEyesChaosMaxDragon.png"));
        moviesList.add(new Movie("Zork", "This movie is about the adventure of a young traveler who was originally visiting his friend. But when his friend was nowhere to be seen he went out to search for him", "dungeon.jpg"));
        moviesList.add(new Movie("Six Legendary Heroes part 1: Hakumen", "This is the tale of the first and leader of the legendary heroes Hakumen", "Hakumen.jpg"));

        BorderPane layout = new BorderPane();

        this.textDisplay = new TextArea("Herzlich Willkommen in unserem Buchungssystem. \nDieses System wird täglich aktualisiert und soll so benutzerfreundlich wie möglich sein. \nViel Spass bei den Filmen.");

        createMovieBildschirm(primaryStage);
        createHall(primaryStage, layout);
        createAdminWindow(primaryStage);
        layout.setBottom(buttons());
        layout.setCenter(this.textDisplay);
        primaryStage.setTitle("Willkommen");
        primaryStage.setScene(new Scene(layout, 600, 175));
        primaryStage.show();
    }


    public GridPane buttons() {

        GridPane DontPushMe = new GridPane();

        Button Admin = new Button("Admin");
        Button Film = new Button("Movie");

        DontPushMe.setPadding(new Insets(10));
        DontPushMe.setHgap(20);

        Admin.setPadding(new Insets(10));
        Film.setPadding(new Insets(10));

        Film.setOnAction(event -> this.MovieBildschirm.show());
        Admin.setOnAction(event -> this.Admin.show());

        DontPushMe.add(Admin, 0, 0);
        DontPushMe.add(Film, 1, 0);

        return DontPushMe;
    }

    public Button createMovieItem(Movie mov, Stage primaryStage) {

        Button movie = new Button(mov.getTitle());
        movie.setContentDisplay(ContentDisplay.TOP);
        movie.setOnAction(event -> {
            createMovieDescription(mov, primaryStage);
            this.MovieDescription.show();
        });
        Image background = new Image(getClass().getResourceAsStream(mov.getImageFile()), 300, 300, false, false);
        movie.setGraphic(new ImageView(background));

        return movie;
    }

    public void createMovieBildschirm(Stage primaryStage) {
        BorderPane layout = new BorderPane();

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        int col = 0;
        int row = 0;
        for (int i = 0; i < moviesList.size(); i++) {

            if (i != 0 && i % 3 == 0) {
                row += 1;
                col = 0;
            }
            grid.add(createMovieItem(moviesList.get(i), primaryStage), col, row);
            col++;
        }

        /*Button movie1 = new Button("Blue-Eyes Chaos Max Dragon");
        Button movie2 = new Button("Zork");
        Button movie3 = new Button("Six Legendary Heroes part 1: Hakumen");

        movie1.setContentDisplay(ContentDisplay.TOP);
        movie2.setContentDisplay(ContentDisplay.TOP);
        movie3.setContentDisplay(ContentDisplay.TOP);
*/
       /* movie1.setOnAction(event -> {
            createMovieDescription(new Movie("Blue-Eyes Chaos Max Dragon", "The Struggle of humanity\nagainst the Titular \nBlue-Eyes Chaos Max Dragon. \nWill humanity be able to emerge \nvictorious against this near \ngodlike creature!?"), primaryStage);
            this.MovieDescription.show();
        });

        movie2.setOnAction(event -> {
            createMovieDescription(new Movie("Zork", "This movie is about the adventure of a young traveler who was originally visiting his friend. But when his friend was nowhere to be seen he went out to search for him"), primaryStage);
            this.MovieDescription.show();
        });

        movie3.setOnAction(event -> {
            createMovieDescription(new Movie("Six Legendary Heroes part 1: Hakumen", "This is the tale of the first and leader of the legendary heroes Hakumen"), primaryStage);
            this.MovieDescription.show();
        });*/

        /*BackgroundImage backgroundImage = new BackgroundImage(new Image(getClass().getResource("dungeon.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);*/

        /*BackgroundImage backgroundImage2 = new BackgroundImage(new Image(getClass().getResource("Hakumen.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background2 = new Background(backgroundImage2);*/

        /*Image background = new Image(getClass().getResourceAsStream("BlueEyesChaosMaxDragon.png"), 300, 300, false, false);
        Image background2 = new Image(getClass().getResourceAsStream("dungeon.jpg"), 300, 300, false, false);
        Image background3 = new Image(getClass().getResourceAsStream("Hakumen.jpg"), 300, 300, false, false);*/

        /*movie1.setGraphic(new ImageView(background));
        movie2.setGraphic(new ImageView(background2));
        movie3.setGraphic(new ImageView(background3));*/

        /*grid.add(movie1, 0, 0);
        grid.add(movie2, 1, 0);
        grid.add(movie3, 2, 0);
        /*final ImageView selectedImage = new ImageView();
        Image image1 = null;
        try {
            image1 = new Image(new FileInputStream("C:\\Users\\d.buetikofer\\Documents\\GitHub\\pics\\dungeon.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/


        /*WebView browser = new WebView();
        WebEngine engine = browser.getEngine();
        String url = getClass().getResource("movies.html").toExternalForm();
        engine.load(url);
        //selectedImage.setImage(image1);

        //grid.add(selectedImage, 0, 0);

        StackPane sp = new StackPane();
        BorderPane bp = new BorderPane();

        bp.setCenter(browser);
        sp.getChildren().add(bp);*/


        this.MovieBildschirm = new Stage();
        this.MovieBildschirm.setTitle("Movies");
        this.MovieBildschirm.initOwner(primaryStage);
        this.MovieBildschirm.initModality(Modality.WINDOW_MODAL);
        this.MovieBildschirm.setScene(new Scene(layout, 1000, 1000));
        layout.setLeft(grid);

        //return sp;
    }

    public void createHall(Stage primaryStage, BorderPane mainlayout) {
        BorderPane layout = new BorderPane();
        this.Hall = new Stage();
        this.Hall.setTitle("Hall");
        this.Hall.initOwner(primaryStage);
        this.Hall.initModality(Modality.WINDOW_MODAL);
        this.Hall.setScene(new Scene(layout, 100, 100));
    }

    public void createMovieDescription(Movie movie, Stage primaryStage) {
        BorderPane layout = new BorderPane();
        GridPane textLayout = new GridPane();
        textLayout.setPadding(new Insets(10));

        Label title = new Label(movie.getTitle());
        Label description = new Label(movie.getDescription());

        title.setFont(javafx.scene.text.Font.font(20));
        description.setWrapText(true);
        textLayout.add(title, 0, 0);
        textLayout.add(description, 0, 1);
        layout.setCenter(textLayout);
        this.MovieDescription = new Stage();
        this.MovieDescription.setTitle(movie.getTitle());
        this.MovieDescription.initOwner(primaryStage);
        this.MovieDescription.initModality(Modality.WINDOW_MODAL);
        this.MovieDescription.setScene(new Scene(layout, 400, 400));
    }

    public void createAdminWindow(Stage primaryStage) {
        BorderPane layout = new BorderPane();
        GridPane grid = new GridPane();
        FileChooser chooser = new FileChooser();

        Label filmNameLabel = new Label("Film Name");
        TextField filmName = new TextField();
        Label filmDescriptionLabel = new Label("Film Description");
        TextArea filmDescription = new TextArea();
        Button selectImageButton = new Button("Select Image");
        Button submitBtn = new Button("Add");

        Movie movie = new Movie();

        String path = "src/sample/";

        chooser.setTitle("Load Image File");

        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        grid.add(filmNameLabel, 0, 0);
        grid.add(filmName, 0, 1);
        grid.add(filmDescriptionLabel, 0, 2);
        grid.add(filmDescription, 0, 3);
        grid.add(selectImageButton, 0, 4);
        grid.add(submitBtn, 0, 5);

        layout.setCenter(grid);
        this.Admin = new Stage();
        this.Admin.setTitle("Admin");
        this.Admin.initOwner(primaryStage);
        this.Admin.initModality(Modality.WINDOW_MODAL);
        this.Admin.setScene(new Scene(layout, 400, 400));

        selectImageButton.setOnAction(event -> {
            File file = chooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    Files.copy(file.toPath(),
                            (new File(path + file.getName())).toPath(),
                            StandardCopyOption.REPLACE_EXISTING);
                    movie.setImageFile(file.getName());
                } catch (IOException e) {
                    System.out.println(file.getName());
                }
            }
        });

        submitBtn.setOnAction(event -> {
            if (filmName.getText().isEmpty()) {
                filmName.setStyle("-fx-background-color: red");

            } else {
                movie.setTitle(filmName.getText());
            }

            if (filmDescription.getText().isEmpty()) {
                filmDescription.setStyle("-fx-background-color: red");
            } else {
                movie.setDescription(filmDescription.getText());
            }

            if(!movie.getDescription().isEmpty() && !movie.getImageFile().isEmpty() && !movie.getTitle().isEmpty()){
                this.moviesList.add(new Movie(movie.getTitle(), movie.getDescription(), movie.getImageFile()));
                createMovieBildschirm(primaryStage);
                filmDescription.setText("");
                filmName.setText("");
                movie.setDescription("");
                movie.setTitle("");
                movie.setImageFile("");
                this.Admin.hide();


            } else {
                System.out.println(movie.toString());
            }

        });


    }

    public static void main(String[] args) {
        launch(args);
    }
}
