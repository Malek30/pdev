package client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.UserServicesEJBRemote;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import javafx.event.ActionEvent;

public class frame1Controller implements Initializable{
	@FXML
	private TextField login;
	@FXML
	private TextField pwd;
	@FXML
	private Button l1;
	@FXML
	private Button l2;
	@FXML
	private Button exit;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
  @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, NamingException {
    	InitialContext ctx=new InitialContext();
		Object objet=ctx.lookup("/easyMission-ear/easyMission-ejb/UserServicesEJB!services.UserServicesEJBRemote");
		UserServicesEJBRemote proxy=(UserServicesEJBRemote)objet;
		
		User u1=proxy.findUserBYLoginAndPassword(login.getText(),pwd.getText());
		System.out.println(u1.getFirstName());
		if(u1!=null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Welcome ");
alert.setHeaderText(null);
alert.setContentText("welcome "+u1.getFirstName()+" "+u1.getLastName()+" :)" );

alert.showAndWait();
    }else{
    	 Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	 alert.setTitle("wrong id ");
    	 alert.setHeaderText(null);
    	 alert.setContentText("wrong ");

    	 alert.showAndWait();
    }
		//Stage stage = (Stage) l1.getScene().getWindow();
	    //stage.close();
    }
    @FXML
    private void handleButton2Action(ActionEvent event) throws IOException, NamingException {
    	Stage stage = (Stage) l1.getScene().getWindow();
	    stage.close();
	    Parent root = FXMLLoader.load(getClass().getResource("frame2.fxml"));
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
    }
    @FXML
    private void handleButton3Action(ActionEvent event) throws IOException, NamingException {
    	Stage stage = (Stage) l1.getScene().getWindow();
	    stage.close();
    }
	
}
