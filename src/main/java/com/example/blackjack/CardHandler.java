package com.example.blackjack;

import com.example.blackjack.model.Card;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import javafx.scene.image.Image;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class CardHandler {

    protected void readCards() throws IOException {

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/cards/deck-of-cards.json"));
        Card[] baseCards = gson.fromJson(reader, Card[].class);

        for (Card baseCard : baseCards) {
            Card card = new Card(baseCard.getValueOfCard(), baseCard.getIndexOfCard(), baseCard.getImagePath(), new Image(Objects.requireNonNull(getClass().getResourceAsStream(baseCard.getImagePath()))));
            BlackJackApplication.cards.add(card);
        }
    }

    public static Card getRandomCard() {
        Random random = new Random();
        int randomFactor = random.nextInt(BlackJackApplication.cards.size() - 2);

        return BlackJackApplication.cards.get(randomFactor);
    }

    public Image getCardImage(Card card) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(card.getImagePath())));
    }

    public static Image getStaticCardImage(Card card) {
        CardHandler cardHandler = new CardHandler();

        return cardHandler.getCardImage(card);
    }

    public static Card getReverseCard(){
        return BlackJackApplication.cards.get(52);
    }

}
