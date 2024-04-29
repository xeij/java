package com.example.collab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Metrics extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        
        Label titleLabel = new Label("Performance Metrics");
        root.getChildren().add(titleLabel);

        // BST INSERT
        BST test1 = new BST();
        test1.insert(0);
        double start = System.currentTimeMillis();
        test1.insert(0);
        double end = System.currentTimeMillis();
        double totalTime = end - start;
        Label bstInsertLabel = new Label("BST INSERT: " + String.format("%.2f", totalTime));
        root.getChildren().add(bstInsertLabel);

        // AVL INSERT
        AVLTree test2 = new AVLTree();
        test2.insert(0);
        long start2 = System.currentTimeMillis();
        test2.insert(0);
        long end2 = System.currentTimeMillis();
        long totalTime2 = end2 - start2;
        Label avlInsertLabel = new Label("AVL INSERT: " + totalTime2);
        root.getChildren().add(avlInsertLabel);

        // BST SEARCH
        BST test3 = new BST();
        test3.insert(0);
        long start3 = System.currentTimeMillis();
        test3.search(0);
        long end3 = System.currentTimeMillis();
        long totalTime3 = end3 - start3;
        Label bstSearchLabel = new Label("BST SEARCH: " + totalTime3);
        root.getChildren().add(bstSearchLabel);

        // AVL SEARCH
        AVLTree test4 = new AVLTree();
        test4.insert(0);
        long start4 = System.currentTimeMillis();
        test4.search(0);
        long end4 = System.currentTimeMillis();
        long totalTime4 = end4 - start4;
        Label avlSearchLabel = new Label("AVL SEARCH: " + totalTime4);
        root.getChildren().add(avlSearchLabel);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Performance Metrics");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

