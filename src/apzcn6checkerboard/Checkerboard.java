/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apzcn6checkerboard;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author apzib
 */
public class Checkerboard {
    private double boardWidth;
    private double boardHeight;
    private double rectangleWidth;
    private double rectangleHeight;
    private int numRows;
    private int numCols;
    
    private Color lightColor;
    private Color darkColor;
    private AnchorPane board;
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        board = new AnchorPane();
    }
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
         board = new AnchorPane();
    }
    public AnchorPane buildBoard(double boardWidth, double boardHeight){
          
        clear();
        rectangleWidth = Math.ceil(boardWidth / (double)numCols);
        rectangleHeight = Math.ceil(boardHeight / (double)numRows);
        board.setPrefWidth(boardWidth);
        board.setPrefHeight(boardHeight);
        
        for(int i = 0; i <numRows; i++){
            for(int q =0; q< numCols; q++){
                Rectangle checker = new Rectangle();
                checker.setWidth(rectangleWidth);
                checker.setHeight(rectangleHeight);
                checker.setY(rectangleHeight*q);
                checker.setX(rectangleWidth*i);
                if((q % 2 ==0 && i % 2 !=0) || (q % 2 !=0 && i % 2 == 0)){
                    checker.setFill(darkColor);
                }
                else
                {
                    checker.setFill(lightColor);
                }
                board.getChildren().add(checker);
                
            }
        }
        return board;
    }
    public AnchorPane getBoard(){
        return board;
    }
    public int getNumCols(){
        return numCols;
    }
    public int getNumRows(){
        return numRows;
    }
    public double getWidth(){
        return boardWidth;
    }
    public double getHeight(){
        return boardHeight;
    }
    public Color getLightColor(){
        return lightColor;
    }
    public Color getdarkColor(){
        return darkColor;
    }
    public double getRectangleWidth(){
        return rectangleWidth;
    }
    public double getRectangleHeight(){
        return rectangleHeight;
    }
    public void clear(){
        board.getChildren().clear();
    }
}
