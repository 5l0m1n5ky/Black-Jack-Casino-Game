package com.example.blackjack.model;

import javafx.scene.image.Image;

public abstract class BaseCard {

    protected transient Image image;

    protected BaseCard(Image image) {
        this.image = image;
    }

}

