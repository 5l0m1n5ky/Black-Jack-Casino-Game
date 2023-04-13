package com.example.blackjack;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BlackJackController {

    Stage anotherStage;
    Parent anotherFxmlLoader;

    Effects effects = new Effects();

    public static int playerCounter = 0;
    public static int dealerCounter = 0;

    static List<Boolean> cardsToCreate = new ArrayList<>();
    static List<String> playerStack = new ArrayList<>();

    @FXML
    private ImageView table;

    @FXML
    private ImageView hitGlow;

    @FXML
    private ImageView standGlow;

    @FXML
    private ImageView startGlow;

    @FXML
    private ImageView playAgainGlow;

    @FXML
    private Label counterContent;

    @FXML
    private Pane tablePane;

    @FXML
    private ImageView hitButton;

    @FXML
    private ImageView standButton;

    @FXML
    private ImageView startButton;

    @FXML
    private ImageView playAgainButton;

    @FXML
    private ImageView dealerWinner;

    @FXML
    private ImageView playerWinner;

    @FXML
    private ImageView noOneWinner;

    @FXML
    private ImageView counterImage;

    @FXML
    void startGlowOn(MouseEvent event) {
        startGlow.setOpacity(1);
    }

    @FXML
    void startGlowOff(MouseEvent event) {
        startGlow.setOpacity(0);
    }


    @FXML
    void hitGlowOn(MouseEvent event) {
        hitGlow.setOpacity(1);
    }

    @FXML
    void hitGlowOff(MouseEvent event) {
        hitGlow.setOpacity(0);
    }

    @FXML
    void standGlowOn(MouseEvent event) {
        standGlow.setOpacity(1);
    }

    @FXML
    void standGlowOff(MouseEvent event) {
        standGlow.setOpacity(0);
    }

    @FXML
    void playAgainGlowOn(MouseEvent event) {playAgainGlow.setOpacity(1);}

    @FXML
    void playAgainGlowOff(MouseEvent event) {
        playAgainGlow.setOpacity(0);
    }

    @FXML
    void start(MouseEvent event) {
        setFirstFourCards();
        startButton.setDisable(true);
        hitButton.setDisable(false);
        standButton.setDisable(false);
    }

    @FXML
    void hit(MouseEvent event) {
        effects.transition(600, tablePane, dealerWinner, playerWinner, noOneWinner, counterContent, true, playAgainButton, playAgainGlow, hitButton);
    }

    @FXML
    void stand(MouseEvent event) {
        standButton.setDisable(true);
        effects.fade(600, tablePane, dealerWinner, playerWinner, noOneWinner, playAgainButton, playAgainGlow, hitButton);
    }

    @FXML
    void playAgain(MouseEvent event) throws IOException {
        playerCounter = 0;
        dealerCounter = 0;

        Effects.setToXPlayerStack = 0;
        Effects.setToYPlayerStack = 696;
        Effects.setToXDealerStack = 3;
        Effects.setToYDealerStack = 217;

        playerStack.clear();
        cardsToCreate.clear();

        anotherStage = (Stage) playAgainButton.getScene().getWindow();
        anotherFxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/BJ_table.fxml")));
        Scene scene = new Scene(anotherFxmlLoader, Color.BLACK);
        anotherStage.setScene(scene);
        anotherStage.show();
        Effects.fade(anotherFxmlLoader,600);
    }

    public void setFirstFourCards() {

        cardsToCreate = new ArrayList<>();
        cardsToCreate.add(true);
        cardsToCreate.add(false);
        cardsToCreate.add(true);
        cardsToCreate.add(false);
        effects.transition(tablePane, counterContent, 600);
    }

}


