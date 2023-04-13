package com.example.blackjack;

import com.example.blackjack.model.Card;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.concurrent.TimeUnit;

public class Effects {

    private static final int setFromX = 711;
    private static final int setFromY = -198;

    protected static int setToXPlayerStack = 0;
    protected static int setToYPlayerStack = 696;
    protected static int setToXDealerStack = 3;
    protected static int setToYDealerStack = 217;


    public static void fade(Node node, int duration) {
        FadeTransition fade = new FadeTransition(Duration.millis(duration), node);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setCycleCount(1);
        fade.play();
    }

    public static void fade(Node node, int duration, ImageView playAgainButton, ImageView playAgainGlow) {
        FadeTransition fade = new FadeTransition(Duration.millis(duration), node);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setCycleCount(1);
        fade.play();
        fade.setOnFinished(e -> {
            playAgainButton.setOpacity(1);
            playAgainButton.setDisable(false);
            playAgainGlow.toFront();
            playAgainButton.toFront();
        });
    }

    public void fade(int duration, Pane tablePane, ImageView dealerWinner, ImageView playerWinner, ImageView noOneWinner, ImageView playAgainButton, ImageView playAgainGlow, ImageView hitButton) {

        Card card = CardHandler.getRandomCard();

        BlackJackController.dealerCounter = BlackJackController.dealerCounter + (card.getValueOfCard().equalsIgnoreCase("ace") ? 11 : Integer.parseInt(card.getValueOfCard()));

        Image image = CardHandler.getStaticCardImage(card);
        ImageView imageView = new ImageView();

        imageView.setX(683);
        imageView.setY(49);
        imageView.setImage(image);
        imageView.setOpacity(0);
        tablePane.getChildren().add(imageView);
        imageView.toFront();
        imageView.setFitHeight(181);
        imageView.setFitWidth(113);
        imageView.setSmooth(true);

        FadeTransition fade = new FadeTransition(Duration.millis(duration), imageView);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setCycleCount(1);
        fade.play();
        fade.setOnFinished(e -> {
            dealerStackCheck(dealerWinner, playerWinner, noOneWinner, tablePane, playAgainButton, playAgainGlow, hitButton);
        });
    }


    public void transition(int duration, Pane tablePane, ImageView dealerWinner, ImageView playerWinner, ImageView noOneWinner, Label counterContent, boolean forPlayer, ImageView playAgainButton, ImageView playAgainGlow, ImageView hitButton) {

        Card card = CardHandler.getRandomCard();
        Image image = CardHandler.getStaticCardImage(card);
        ImageView imageView = new ImageView();

        imageView.setX(711);
        imageView.setY(-198);
        imageView.setImage(image);
        tablePane.getChildren().add(imageView);
        imageView.toFront();
        imageView.setFitHeight(181);
        imageView.setFitWidth(113);
        imageView.setSmooth(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(duration), imageView);

        if (forPlayer) {
            BlackJackController.playerStack.add(card.getValueOfCard());
            translateTransition.setToX(setToXPlayerStack);
            translateTransition.setToY(setToYPlayerStack);
            setToXPlayerStack = setToXPlayerStack + 30;
            setToYPlayerStack = setToYPlayerStack - 30;

            BlackJackController.playerCounter = BlackJackController.playerCounter + (card.getValueOfCard().equalsIgnoreCase("ace") ? 11 : Integer.parseInt(card.getValueOfCard()));
            counterContent.setText(Integer.toString(BlackJackController.playerCounter));
            DropShadow shadow = new DropShadow();
            shadow.setOffsetY(5.0);
            counterContent.setEffect(shadow);
        } else {
            translateTransition.setToX(setToXDealerStack);
            translateTransition.setToY(setToYDealerStack);
            setToXDealerStack = setToXDealerStack - 30;
            setToYDealerStack = setToYDealerStack + 30;

            BlackJackController.dealerCounter = BlackJackController.dealerCounter + (card.getValueOfCard().equalsIgnoreCase("ace") ? 11 : Integer.parseInt(card.getValueOfCard()));
        }
        translateTransition.play();
        translateTransition.setOnFinished(e -> {
            if (forPlayer) {
                playerStackCheck(dealerWinner, playAgainButton, playAgainGlow, hitButton);
            } else {
                dealerStackCheck(dealerWinner, playerWinner, noOneWinner, tablePane, playAgainButton, playAgainGlow, hitButton);
            }
        });
    }

    public void transition(Pane tablePane, Label counterContent, int duration) {
        if (BlackJackController.cardsToCreate.isEmpty()) {
            return;
        }

        boolean forPlayer = BlackJackController.cardsToCreate.get(0);
        BlackJackController.cardsToCreate.remove(0);

        Card card = BlackJackController.cardsToCreate.size() > 0 ? CardHandler.getRandomCard() : CardHandler.getReverseCard();
        Image image = CardHandler.getStaticCardImage(card);

        ImageView imageView = new ImageView();

        imageView.setImage(image);
        imageView.setX(711);
        imageView.setY(-198);
        tablePane.getChildren().add(imageView);
        imageView.toFront();
        imageView.setPreserveRatio(false);
        imageView.setFitHeight(181);
        imageView.setFitWidth(113);
        imageView.setSmooth(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(duration), imageView);

        if (forPlayer) {
            BlackJackController.playerStack.add(card.getValueOfCard());
            translateTransition.setToX(setToXPlayerStack);
            translateTransition.setToY(setToYPlayerStack);
            setToXPlayerStack = setToXPlayerStack + 30;
            setToYPlayerStack = setToYPlayerStack - 30;
            translateTransition.play();

            BlackJackController.playerCounter = BlackJackController.playerCounter + (card.getValueOfCard().equalsIgnoreCase("ace") ? 11 : Integer.parseInt(card.getValueOfCard()));
            counterContent.setText(Integer.toString(BlackJackController.playerCounter));
            DropShadow shadow = new DropShadow();
            shadow.setOffsetY(5.0);
            counterContent.setEffect(shadow);
        } else {
            BlackJackController.dealerCounter = BlackJackController.dealerCounter + (card.getValueOfCard().equalsIgnoreCase("ace") ? 11 : Integer.parseInt(card.getValueOfCard()));

            translateTransition.setToX(setToXDealerStack);
            translateTransition.setToY(setToYDealerStack);
            setToXDealerStack = setToXDealerStack - 30;
            setToYDealerStack = setToYDealerStack + 30;
            translateTransition.play();
        }
        translateTransition.setOnFinished(e -> {
            transition(tablePane, counterContent, 600);
        });
    }

    public static void delay(int durationMillis) {
        try {
            TimeUnit.MILLISECONDS.sleep(durationMillis);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    public void playerStackCheck(ImageView dealerWinner, ImageView playAgainButton, ImageView playAgainGlow, ImageView hitButton) {
        Effects.delay(1000);

        if (BlackJackController.playerCounter > 21) {
            if (BlackJackController.playerStack.contains("ace")) {
                BlackJackController.playerCounter = BlackJackController.playerCounter - 10;
                BlackJackController.playerStack.remove("ace");
            } else {
                hitButton.setDisable(true);
                dealerWinner.toFront();
                fade(dealerWinner, 600, playAgainButton, playAgainGlow);
            }
        }
    }

    public void dealerStackCheck(ImageView dealerWinner, ImageView playerWinner, ImageView noOneWinner, Pane tablePane, ImageView playAgainButton, ImageView playAgainGlow, ImageView hitButton) {
        if (BlackJackController.dealerCounter < 17) {
            Effects.delay(1000);
            transition(600, tablePane, dealerWinner, playerWinner, noOneWinner, null, false, playAgainButton, playAgainGlow, hitButton);
        } else if (BlackJackController.dealerCounter > 21) {
            hitButton.setDisable(true);
            delay(1000);
            playerWinner.toFront();
            fade(playerWinner, 600, playAgainButton, playAgainGlow);
        } else if (BlackJackController.playerCounter == BlackJackController.dealerCounter) {
            hitButton.setDisable(true);
            delay(1000);
            noOneWinner.toFront();
            fade(noOneWinner, 600, playAgainButton, playAgainGlow);
        } else if (BlackJackController.playerCounter > BlackJackController.dealerCounter) {
            hitButton.setDisable(true);
            delay(1000);
            playerWinner.toFront();
            fade(playerWinner, 600, playAgainButton, playAgainGlow);
        } else {
            hitButton.setDisable(true);
            delay(1000);
            dealerWinner.toFront();
            fade(dealerWinner, 600, playAgainButton, playAgainGlow);
        }
    }
}



