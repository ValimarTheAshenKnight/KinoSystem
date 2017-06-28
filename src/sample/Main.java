package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main extends Application {


    private Stage MovieBildschirm;

    private TextArea textDisplay;

    private Stage Hall;

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane layout = new BorderPane();

        this.textDisplay = new TextArea("Herzlich Willkommen in unserem Buchungssystem. \nDieses System wird täglich aktualisiert und soll so benutzerfreundlich wie möglich sein. \nViel spass bei den Filmen.");

        createMovieBildschirm(primaryStage, layout);
        createHall(primaryStage, layout);
        layout.setBottom(buttons());
        layout.setCenter(this.textDisplay);
        primaryStage.setTitle("Willkommen");
        primaryStage.setScene(new Scene(layout, 480, 175));
        primaryStage.show();
    }


    public GridPane buttons(){

        GridPane DontPushMe = new GridPane();

        Button Admin = new Button("Admin");
        Button Film = new Button("Movie");

        DontPushMe.setPadding(new Insets(10));
        DontPushMe.setHgap(20);

        Admin.setPadding(new Insets(10));
        Film.setPadding(new Insets(10));

        Film.setOnAction(event -> this.MovieBildschirm.show());

        DontPushMe.add(Admin, 0, 0);
        DontPushMe.add(Film, 1, 0);

        return DontPushMe;
    }

    public void createMovieBildschirm(Stage primaryStage, BorderPane mainLayout){
        BorderPane layout = new BorderPane();

        GridPane grid = new GridPane();
        /*final ImageView selectedImage = new ImageView();
        Image image1 = null;
        try {
            image1 = new Image(new FileInputStream("C:\\Users\\d.buetikofer\\Documents\\GitHub\\pics\\dungeon.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/


        WebView browser = new WebView();
        WebEngine engine = browser.getEngine();
        String url = getClass().getResource("movies.html").toExternalForm();
        engine.load(url);
        //selectedImage.setImage(image1);

        //grid.add(selectedImage, 0, 0);

        StackPane sp = new StackPane();
        BorderPane bp = new BorderPane();

        bp.setCenter(browser);
        sp.getChildren().add(bp);


        this.MovieBildschirm = new Stage();
        this.MovieBildschirm.setTitle("Movies");
        this.MovieBildschirm.initOwner(primaryStage);
        this.MovieBildschirm.initModality(Modality.WINDOW_MODAL);
        this.MovieBildschirm.setScene(new Scene(sp,1000,1000));

        //return sp;
    }

    public void createHall(Stage primaryStage, BorderPane mainlayout){
        BorderPane layout = new BorderPane();
        this.Hall = new Stage();
        this.Hall.setTitle("Hall");
        this.Hall.initOwner(primaryStage);
        this.Hall.initModality(Modality.WINDOW_MODAL);
        this.Hall.setScene(new Scene(layout,100,100));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
