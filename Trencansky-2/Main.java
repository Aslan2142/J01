package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static String samohlasky = "aeiouäáéíóú";
    public static String spoluhlasky = "dtnlhgkďťňľcčšjmbpvzsfr";

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox root = new HBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(6);
        Scene scene = new Scene(root, 480, 360);

        TextField inputField = new TextField();
        Button inputButton = new Button("OK");
        inputButton.setVisible(false);

        inputButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String text = inputField.getText();

                if (text.length() == 0)
                {
                    return;
                }

                Text outputText = new Text(text);
                outputText.setFont(new Font(26));
                root.getChildren().add(outputText);
                root.getChildren().removeAll(inputField, inputButton);

                BackgroundFill bg = new BackgroundFill(Color.rgb(
                        clamp(getOccurences(text, samohlasky) * 16, 0, 255),
                        clamp(getOccurences(text, spoluhlasky) * 24, 0, 255),
                        clamp((text.length() % 25) * 10, 0, 255)
                ), null, null);

                root.setBackground(new Background(bg));
            }
        });

        inputField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                inputButton.setVisible(inputField.getText().length() > 0);
            }
        });

        root.getChildren().addAll(inputField, inputButton);

        primaryStage.setTitle("JavaFX Test - Ján Trenčanský");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public int getOccurences(String input, String textToCompare)
    {
        int count = 0;

        for (int i = 0; i < input.length(); i++)
        {
            if (textToCompare.contains(input.substring(i, i + 1)))
            {
                count++;
            }
        }

        return count;
    }

    public int clamp(int value, int min, int max)
    {
        value = value < min ? min : value;
        value = value > max ? max : value;
        return value;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
