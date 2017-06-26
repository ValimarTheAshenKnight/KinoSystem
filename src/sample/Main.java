package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

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

        DontPushMe.add(Admin, 4, 0);
        DontPushMe.add(Film, 5, 0);

        return DontPushMe;
    }

    public void createMovieBildschirm(Stage primaryStage, BorderPane mainLayout){
        BorderPane layout = new BorderPane();
        Button seats = new Button("Hall 1");
        seats.setPadding(new Insets(100));
        seats.setOnAction(event -> this.Hall.show());

        layout.setCenter(seats);

        this.MovieBildschirm = new Stage();
        this.MovieBildschirm.setTitle("Movies");
        this.MovieBildschirm.initOwner(primaryStage);
        this.MovieBildschirm.initModality(Modality.WINDOW_MODAL);
        this.MovieBildschirm.setScene(new Scene(layout,1000,1000));

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
