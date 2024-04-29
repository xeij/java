package com.example.collab;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

class AVLTreeView extends Pane {
    private AVLTree avlTree;

    AVLTreeView(AVLTree avlTree) {
        this.avlTree = avlTree;
    }

    void update() {
        getChildren().clear();
        drawTree(avlTree.root, getWidth() / 2, 50, getWidth() / 4);
    }

    private void drawTree(Node root, double x, double y, double hGap) {
        if (root != null) {
            Circle circle = new Circle(x, y, 15);
            circle.setFill(null); 
            circle.setStroke(Color.BLACK); 

            getChildren().add(circle);

            Text text = new Text(x - 4, y + 4, String.valueOf(root.value));
            getChildren().add(text);

            if (root.left != null) {
                double xLeft = x - hGap;
                double yLeft = y + 60;
                drawLine(x, y + 15, xLeft, yLeft - 15);
                drawTree(root.left, xLeft, yLeft, hGap / 2);
            }
            if (root.right != null) {
                double xRight = x + hGap;
                double yRight = y + 60;
                drawLine(x, y + 15, xRight, yRight - 15);
                drawTree(root.right, xRight, yRight, hGap / 2);
            }
        }
    }

    private void drawLine(double startX, double startY, double endX, double endY) {
        Line line = new Line(startX, startY, endX, endY);
        getChildren().add(line);
    }
}
