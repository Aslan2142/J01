package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    private static ObservableList<Node> children;
    private static Paint strokeColor = Color.BLACK;
    private static double strokeWidth = 5;
    private static double lastPositionX = 0;
    private static double lastPositionY = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        children = root.getChildren();
        Scene scene = new Scene(root, 720, 406);
        scene.setFill(Color.BLACK);

        // Drawing
        {
            strokeColor = Color.PURPLE;
            DrawLine(113, 209, 102, 223);
            DrawLine(142, 223);
            DrawLine(102, 173);
            DrawLine(142, 173);
            DrawLine(130, 188);

            strokeColor = Color.YELLOW;
            DrawLine(246, 190, 261, 190);
            DrawLine(270, 173);
            DrawLine(218, 173);
            DrawLine(244, 223);
            DrawLine(252, 208);

            strokeColor = Color.RED;
            DrawLine(375, 194, 392, 223);
            DrawLine(338, 223);
            DrawLine(366, 173);

            strokeColor = Color.GREEN;
            DrawLine(505, 191, 487, 223);
            DrawLine(459, 173);
            DrawLine(513, 173);

            strokeColor = Color.CYAN;
            DrawLine(607, 205, 591, 205);
            DrawLine(579, 223);
            DrawLine(636, 223);
            DrawLine(607, 173);
            DrawLine(597, 189);
        }
        //

        primaryStage.setTitle("JavaFX Test - Ján Trenčanský");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void DrawLine(double endX, double endY)
    {
        DrawLine(lastPositionX, lastPositionY, endX, endY);
    }

    public static void DrawLine(double startX, double startY, double endX, double endY)
    {
        Line lineShape = new Line(startX, startY, endX, endY);
        lineShape.setStroke(strokeColor);
        lineShape.setStrokeWidth(strokeWidth);

        Glow glowEffect = new Glow(8);
        lineShape.setEffect(glowEffect);

        children.add(lineShape);

        lastPositionX = endX;
        lastPositionY = endY;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
