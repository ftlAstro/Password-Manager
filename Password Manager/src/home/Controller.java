package home;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private VBox pnItems = null;
    
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnClose;
    
    @FXML
    private Button btnClose2;
    
    @FXML
    private Button btnClose3;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;
    
    @FXML
    private Pane pnlLogin;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private PasswordField fieldPassword;
    
    @FXML
    private Button btnAdd;
    
    @FXML
    private PasswordField fieldRegister;
    
    @FXML
    private Button btnRegister;
    
    public int i = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnlLogin.setStyle("-fx-background-color : #02030A");
        pnlLogin.toFront();
        btnLogin.toFront();
        File f = new File("master.txt");
        if(f.exists() && !f.isDirectory()) {
        	btnLogin.setDisable(false);
        	btnLogin.setVisible(true);
        	fieldPassword.setDisable(false);
        	fieldPassword.setVisible(true);
        	fieldRegister.setDisable(true);
            fieldRegister.setVisible(false);
            btnRegister.setDisable(true);
            btnRegister.setVisible(false);
        }
        else {
        	btnLogin.setDisable(true);
        	btnLogin.setVisible(false);
        	fieldPassword.setDisable(true);
        	fieldPassword.setVisible(false);
        	fieldRegister.setDisable(false);
            fieldRegister.setVisible(true);
            btnRegister.setDisable(false);
            btnRegister.setVisible(true);
        }
        
    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
        }
        if(actionEvent.getSource()==btnClose 
        		|| actionEvent.getSource()==btnClose2 
        		|| actionEvent.getSource()==btnClose3) {
        	Platform.exit();
        }
        if(actionEvent.getSource()==btnLogin) {
        	if(fieldPassword.getText().equals("1234"))
        		pnlLogin.toBack();
        }
        if(actionEvent.getSource()==btnAdd) {
        	Node[] nodes = new Node[500];
            try {
            	final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                nodes[i].setOnMouseEntered(event -> {
                	nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                	nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
            	e.printStackTrace();
            }
            System.out.println(i);
            i++;
        }
    }
}
