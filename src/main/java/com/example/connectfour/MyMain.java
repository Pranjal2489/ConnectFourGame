package com.example.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MyMain extends Application {
    private MyController controller;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MyMain.class.getResource("AppLayout.fxml"));
        GridPane rootGridPane =fxmlLoader.load();

        controller = fxmlLoader.getController();
        controller.createPlayground();

        MenuBar menuBar= createMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);

        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);
        stage.setTitle("LETS PLAY !  CONNECT FOUR GAME !! ");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public MenuBar createMenu(){
//        file menu
        Menu fileMenu = new Menu("File");

        MenuItem newGame= new MenuItem("New Game");
        newGame.setOnAction(actionEvent -> controller.resetGame());//fix

        MenuItem resetGame= new MenuItem("Reset Game");
        resetGame.setOnAction(actionEvent -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();

        MenuItem exitGame= new MenuItem("Exit Game");
        exitGame.setOnAction(actionEvent -> exitGame());
        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);

//        help menu
        Menu helpMenu = new Menu("Help");

        MenuItem aboutGame= new MenuItem("About Game");
        aboutGame.setOnAction(actionEvent -> aboutConnect4Game());
        
        SeparatorMenuItem separator= new SeparatorMenuItem();
        
        MenuItem aboutMe= new MenuItem("About Me");
        aboutMe.setOnAction(actionEvent -> aboutMe());

        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutMe() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Developer");
        alert.setHeaderText("Pranjal");
        alert.setContentText("Hello there! I am a B.tech ECE student and" +
                " This is the connect four game " +
                "i designed using JavaFX. Designing it is super fun and " +
                "easy.");
        alert.show();
    }

    private void aboutConnect4Game() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText(" How To Play ? ");
        alert.setContentText("Connect Four is a two-player connection game in which the"+
                " players first choose a color and then take turns dropping colored discs from the top into "+
                "a seven-column, six-row vertically suspended grid. The pieces fall straight down,"
                +" occupying the next available space within the column. The objective of the"+
                " game is to be the first to form a horizontal, vertical, or diagonal line of f" +
                "our of one's own discs. Connect Four is a solved game. The first player can" +
                " always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {


    }

    public static void main(String[] args) {
        launch(args);
    }
}