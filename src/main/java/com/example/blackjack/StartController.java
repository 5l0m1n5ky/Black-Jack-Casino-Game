package com.example.blackjack;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StartController {

    Stage stage;
    Parent fxmlLoader;

    @FXML
    private ImageView playButton;

    @FXML
    private ImageView playGlow;

    @FXML
    void glowOn(MouseEvent event) {
        playGlow.setOpacity(1);
    }

    @FXML
    void glowOff(MouseEvent event) {
        playGlow.setOpacity(0);
    }

    @FXML
    void playBlackJack(MouseEvent event) throws IOException {
        stage = (Stage) playButton.getScene().getWindow();
        fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/BJ_table.fxml")));
        Scene scene = new Scene(fxmlLoader, Color.BLACK);
        stage.setScene(scene);
        stage.show();
        Effects.fade(fxmlLoader,600);
    }
}
