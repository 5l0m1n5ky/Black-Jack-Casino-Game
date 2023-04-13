package com.example.blackjack;

import com.example.blackjack.model.Card;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BlackJackApplication extends Application {

    private final CardHandler cardHandler = new CardHandler();

    protected static final List<Card> cards = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {

        cardHandler.readCards();

        FXMLLoader fxmlLoader = new FXMLLoader(BlackJackApplication.class.getResource("/fxml/BJ_start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1537, 812);
        stage.setTitle("Black Jack");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}