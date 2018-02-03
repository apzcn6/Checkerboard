/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apzcn6checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author apzib
 */
public class FXMLCheckerboard implements Initializable, Startable{

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Scene scene;
    private int numRows = 8;
    private int numCols = 8;
    private double boardWidth;
    private double boardHeight;
    private apzcn6checkerboard.Checkerboard checkboard;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private VBox vBox;
    @FXML
    private VBox vBoxBoard;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  @FXML  
  private void redColorBoard(ActionEvent event){
      clear();
      lightColor = Color.RED;
      darkColor = Color.BLACK;
      
      setUpGameBoard();
  }
  @FXML
  private void blueColorBoard(ActionEvent event){
      clear();
      lightColor = Color.SKYBLUE;
      darkColor = Color.DARKBLUE;
      
      setUpGameBoard();
  }
  @FXML
  private void x8(ActionEvent event){
      clear();
      numRows = 8;
      numCols = 8;
      setUpGameBoard();
  }
  @FXML
  private void x3(ActionEvent event){
      clear();
      numRows = 3;
      numCols = 3;
      setUpGameBoard();
  }
  @FXML
  private void x10(ActionEvent event){
      clear();
      numRows = 10;
      numCols = 10;
      setUpGameBoard();
  }
  @FXML
  private void x16(ActionEvent event){
      clear();
      numRows = 16;
      numCols = 16;
      setUpGameBoard();
  }
    
  public void setUpGameBoard(){
      
    boardWidth = vBox.getWidth();
    boardHeight = vBox.getHeight() - menuBar.getHeight();


    Checkerboard checkerboard = new Checkerboard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
    AnchorPane board = checkerboard.buildBoard(boardWidth,boardHeight);

    anchorPane.getChildren().clear();
    double horizontalPadding = (boardWidth - (checkerboard.getRectangleWidth() * checkerboard.getNumCols())) / 2;
    double verticalPadding = (boardHeight - (checkerboard.getRectangleHeight() * checkerboard.getNumRows())) / 2;

    // Add padding
    Insets insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
    vBoxBoard.setPadding(insets);
    anchorPane.getChildren().addAll(board);

     
      
      }
  @Override
  public void start(Stage stage){
      this.stage = stage;
    
       
       checkboard = new Checkerboard(numRows, numCols, boardWidth, boardHeight);
       checkboard = new Checkerboard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
       checkboard.buildBoard(boardWidth, boardHeight);
       vBoxBoard.getChildren().add(checkboard.getBoard());
        
      ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
        
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        refresh();

  }
  public void clear(){
      anchorPane.getChildren().clear();
  }
  public void refresh(){
      checkboard.clear();
     checkboard.buildBoard(stage.getWidth(),stage.getHeight());
  }
}
    
