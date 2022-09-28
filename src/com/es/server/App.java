package com.es.server;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public static final Box box = new Box();

    @Override
    public void start(Stage primaryStage) throws Exception {
        initServer();

        box.setWidth(150);
        box.setHeight(100);
        box.setDepth(100);
        box.setTranslateX(400);
        box.setTranslateY(350);
        box.setTranslateZ(0);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.CRIMSON);
        box.setMaterial(material);

        Text header = new Text("Parallelepiped translation");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        header.setX(270);
        header.setY(30);

        Group root = new Group(box, header);
        Scene scene = new Scene(root, 800, 500);

        PerspectiveCamera camera = new PerspectiveCamera();
        scene.setCamera(camera);

        primaryStage.setScene(scene);
        primaryStage.setTitle("corba_lab4");
        primaryStage.show();
    }

    private static void initServer() {
        new Thread(new ServerRunnable()).start();
    }
}
