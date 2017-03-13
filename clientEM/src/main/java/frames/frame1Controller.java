package frames;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.UserServicesEJBRemote;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Employer;
import entities.User;
import entities.Worker;
import javafx.event.ActionEvent;

public class frame1Controller implements Initializable{
	public static Employer e=null;
	public static Worker w=null;
	public static String x="";
	public static int id;
	@FXML
	private TextField login;
	@FXML
	private PasswordField pwd;
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
		User u1=null;
		
		try {
			u1=proxy.findUserBYLoginAndPassword(login.getText(),pwd.getText());
			
		} catch (Exception e) {
			Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
			alert2.setTitle("Wrong Informations ");
			alert2.setHeaderText(null);
			alert2.setContentText("check your Login or your Password" );

			alert2.showAndWait();
		}
		 
		System.out.println(u1.getFirstName());
	
		if(u1.getPassword()!=pwd.getText()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Welcome ");
alert.setHeaderText(null);
alert.setContentText("welcome "+u1.getFirstName()+" "+u1.getLastName()+" :)" );

alert.showAndWait();
id=u1.getIdUser();


Stage stage = (Stage) l1.getScene().getWindow();
stage.close();

if(u1 instanceof Worker){
	Parent root = FXMLLoader.load(getClass().getResource("User2.fxml"));
	Scene scene1 = new Scene(root);
	stage.setScene(scene1);
	stage.show();
	x="worker";
	System.out.println("worker");
}


else{
	Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
	Scene scene1 = new Scene(root);
	stage.setScene(scene1);
	stage.show();
//	x="employer";
	System.out.println("employer");
}
}else{
	Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
	alert2.setTitle("Wrong Informations ");
	alert2.setHeaderText(null);
	alert2.setContentText("check your Login or your Password" );

	alert2.showAndWait();
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
