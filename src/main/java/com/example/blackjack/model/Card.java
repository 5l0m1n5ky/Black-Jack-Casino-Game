package com.example.blackjack.model;

import javafx.scene.image.Image;

public class Card extends BaseCard {

    private String valueOfCard;
    private int indexOfCard;
    private String imagePath;

    public Card(String valueOfCard, int indexOfCard, String imagePath, Image image) {
        super(image);
        this.valueOfCard = valueOfCard;
        this.indexOfCard = indexOfCard;
        this.imagePath = imagePath;
    }

    public String getValueOfCard() {
        return valueOfCard;
    }

    public void setValueOfCard(String valueOfCard) {
        this.valueOfCard = valueOfCard;
    }

    public int getIndexOfCard() {
        return indexOfCard;
    }

    public void setIndexOfCard(int indexOfCard) {
        this.indexOfCard = indexOfCard;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Card=(valueOfCard=" + valueOfCard + ", indexOfCard=" + indexOfCard + ", imagePath=" + imagePath + ", image exists=" + ")";
    }
}



