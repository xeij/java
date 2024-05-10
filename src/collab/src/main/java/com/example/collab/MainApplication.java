package com.example.collab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.awt.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.Scene;

public class MainApplication extends Application {

    Label avlInsertTimeLabel;
    Label avlSearchTimeLabel;
    Label bstInsertTimeLabel;
    Label bstSearchTimeLabel;

    private Scene mainMenu;
    private Scene avl;
    private Scene bst;
    private Scene metric;

    // ALL OF OUR INSTANCES
    private final BST bstObj = new BST();
    private Label bstHeightLabel;
    private Label avlHeightLabel;
    private Pane visualizationPane;
    private final AVLTree avlTree = new AVLTree();
    private TextArea outputArea;
    private AVLTreeView avlTreeView;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        bst = setBst(primaryStage, bstObj);
        metric = setMetric(primaryStage);
        avl = setAvl(primaryStage);
        mainMenu = setMainMenu(avl, bst, metric, primaryStage);
        primaryStage.setScene( mainMenu );
        primaryStage.setTitle("Tree GUI");
        primaryStage.show();
    }
    private Scene setMainMenu( Scene inputAVL, Scene inputBST, Scene inputMetric, Stage primaryInput){
        Button bstButton = new Button("BST Tree");
        Button avlButton = new Button("AVL Tree");
        Button metricsButton = new Button("Metrics ");

        bstButton.setFont(Font.font(25));
        avlButton.setFont(Font.font(25));                          // SET BIGGER BUTTONS
        metricsButton.setFont(Font.font(25));

        bstButton.setOnAction(event -> primaryInput.setScene(inputBST));
        avlButton.setOnAction(event -> primaryInput.setScene(inputAVL));
        metricsButton.setOnAction(event -> primaryInput.setScene(inputMetric));

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);                              // SET BUTTONS TO CENTER
        root.getChildren().addAll(bstButton, avlButton,metricsButton);

        return new Scene(root, 500,500);
    }
    public Scene setAvl(Stage stageInput){
        Button goBack = new Button("Go Back"); // added back button
        goBack.setBackground(Background.fill(Color.LAWNGREEN));
        goBack.setOnAction(actionEvent -> stageInput.setScene(mainMenu));

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        HBox inputHBox = new HBox(10);
        inputHBox.setPadding(new Insets(0, 10, 0, 0));
        TextField insertField = new TextField();
        insertField.setPromptText("Insert value");
        TextField deleteField = new TextField();
        deleteField.setPromptText("Delete value");
        TextField searchField = new TextField();
        searchField.setPromptText("Search value");

        Button insertButton = new Button("Insert");
        insertButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(insertField.getText());
                long startTime = System.nanoTime();
                avlTree.insert(value);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime);
                setAvlInsertTimeLabel(duration);
                updateHeightLabelAVL();
                clearInputFields(insertField, deleteField, searchField);
                avlTreeView.update();
            } catch (NumberFormatException ex) {
                showAlert("Invalid input for insertion!");
            }
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(deleteField.getText());
                avlTree.delete(value);
                updateHeightLabelAVL();
                clearInputFields(insertField, deleteField, searchField);
                avlTreeView.update();
            } catch (NumberFormatException ex) {
                showAlert("Invalid input for deletion!");
            }
        });

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(searchField.getText());
                long startTime = System.nanoTime();
                boolean found = avlTree.search(value);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime);
                setAvlSearchTimeLabel(duration);
                if (found) {
                    showAlert("Value found in the tree.");
                } else {
                    showAlert("Value not found in the tree.");
                }
            } catch (NumberFormatException ex) {
                showAlert("Invalid input for search!");
            }
        });

        inputHBox.getChildren().addAll(insertField, insertButton, deleteField, deleteButton, searchField, searchButton, goBack);
        outputArea = new TextArea();
        outputArea.setEditable(false);
        avlHeightLabel = new Label("Height: ");
        VBox outputVBox = new VBox(10);
        outputVBox.getChildren().add(avlHeightLabel);
        avlTreeView = new AVLTreeView(avlTree);
        root.setTop(avlTreeView);
        root.setCenter(outputVBox);                 
        root.setBottom(inputHBox);

        return new Scene(root, 800,600);
    }
    public Scene setBst(Stage stageInput, BST bst) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        Button goBack = new Button("Go Back"); 
        goBack.setBackground(Background.fill(Color.LAWNGREEN));
        goBack.setOnAction(actionEvent -> stageInput.setScene(mainMenu));


        HBox inputHBox = new HBox(10);
        inputHBox.setPadding(new Insets(0, 10, 0, 0));
        TextField insertField = new TextField();
        insertField.setPromptText("Insert value");
        TextField deleteField = new TextField();
        deleteField.setPromptText("Delete value");
        TextField searchField = new TextField();
        searchField.setPromptText("Search value");

        Button insertButton = new Button("Insert");
        insertButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(insertField.getText());
                long startTime = System.nanoTime();
                bst.insert(value);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime);
                setBstInsertTimeLabel(duration);
                updateHeightLabel(bst);
                clearInputFields(insertField, deleteField, searchField);
                updateVisualization(bst.getRoot());
            } catch (NumberFormatException ex) {
                showAlert("Invalid input for insertion!");
            }
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(deleteField.getText());
                bst.delete(value);
                updateHeightLabel(bst);
                clearInputFields(insertField, deleteField, searchField);
                updateVisualization(bst.getRoot());
            } catch (NumberFormatException ex) {
                showAlert("Invalid input for deletion!");
            }
        });

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(searchField.getText());
                long startTime = System.nanoTime();
                boolean found = bst.search(value);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime);
                setBstSearchTimeLabel(duration);
                if (found) {
                    showAlert("Value found in the tree.");
                } else {
                    showAlert("Value not found in the tree.");
                }
            } catch (NumberFormatException ex) {
                showAlert("Invalid input for search!");
            }
        });

        inputHBox.getChildren().addAll(insertField, insertButton, deleteField, deleteButton, searchField, searchButton, goBack);
        bstHeightLabel = new Label("Height: ");
        VBox outputVBox = new VBox(10);
        outputVBox.getChildren().addAll(bstHeightLabel);
        visualizationPane = new Pane();
        root.setBottom(inputHBox);
        root.setCenter(outputVBox);
        root.setTop(visualizationPane);
        updateVisualization(bst.getRoot());

        return new Scene(root, 800,600);
    }

    private void updateHeightLabelAVL() {
        avlHeightLabel.setText("Height: " + avlTree.height());
    }
    private void updateHeightLabel(BST input) {
        bstHeightLabel.setText("Height: " + input.height() );
    }

    private void clearInputFields(TextField ins, TextField del, TextField sea) {
        ins.clear();
        del.clear();
        sea.clear();
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void updateVisualization(com.example.collab.BST.TreeNode treeNode) {
        visualizationPane.getChildren().clear();
        if (treeNode != null) {
            drawTree(treeNode, 400, 40, 250);
        }
    }

    private void drawTree(com.example.collab.BST.TreeNode treeNode, double x, double y, double hGap) {
        if (treeNode != null) {

            Circle circle = new Circle(x, y, 15);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            visualizationPane.getChildren().addAll(circle, new javafx.scene.text.Text(x - 5, y + 5, Integer.toString(treeNode.val)));


            if (treeNode.left != null) {
                double xLeft = x - hGap;
                double yLeft = y + 60;
                drawTree(treeNode.left, xLeft, yLeft, hGap / 2);
                visualizationPane.getChildren().add(new Line(x, y + 15, xLeft, yLeft - 15));
            }


            if (treeNode.right != null) {
                double xRight = x + hGap;
                double yRight = y + 60;
                drawTree(treeNode.right, xRight, yRight, hGap / 2);
                visualizationPane.getChildren().add(new Line(x, y + 15, xRight, yRight - 15));
            }
        }
    }
    private Scene setMetric(Stage stageInput){

        Button goBack = new Button("Go Back"); // added back button
        goBack.setBackground(Background.fill(Color.LAWNGREEN));
        goBack.setOnAction(actionEvent -> stageInput.setScene(mainMenu));

        VBox root = new VBox();
        Label titleLabel = new Label("Performance Metrics");
        root.getChildren().add(titleLabel);
        BorderPane center = new BorderPane();
        center.setPadding(new Insets(15));
        root.setAlignment(Pos.CENTER);
        center.setCenter(root);
        center.setBottom(goBack);

        // BST INSERT
        bstInsertTimeLabel = new Label("BST INSERT: " + 0 + " nano seconds");
        root.getChildren().add(bstInsertTimeLabel);

        // AVL INSERT
        avlInsertTimeLabel = new Label("AVL INSERT: " + 0 + " nano seconds");
        root.getChildren().add(avlInsertTimeLabel);

        // BST SEARCH
        bstSearchTimeLabel = new Label("BST SEARCH: " + 0 + " nano seconds");
        root.getChildren().add(bstSearchTimeLabel);

        // AVL SEARCH
        avlSearchTimeLabel = new Label("AVL SEARCH: " + 0 + " nano seconds");
        root.getChildren().add(avlSearchTimeLabel);

        return new Scene(center, 500, 500);
    }

    public void setAvlInsertTimeLabel(long input){
        avlInsertTimeLabel.setText("AVL INSERT: " + input + " nano seconds");
    }
    public void setAvlSearchTimeLabel(long input){
        avlSearchTimeLabel.setText("AVL SEARCH: " + input + " nano seconds");
    }
    public void setBstInsertTimeLabel(long input){
        bstInsertTimeLabel.setText("BST INSERT: " + input + " nano seconds");
    }
    public void setBstSearchTimeLabel(long input){
        bstSearchTimeLabel.setText("BST SEARCH: " + input + " nano seconds");
    }


}
