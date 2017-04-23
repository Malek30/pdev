package frames;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import security.callbackHandler;
import security.loginModule;
import services.UserServicesEJBRemote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import delegate.UserServiceDelegate;
import entities.Employer;
import entities.User;
import entities.Worker;
import javafx.event.ActionEvent;

public class frame1Controller implements Initializable{
	UserServiceDelegate delegate= new UserServiceDelegate();
	//SecurityServiceDelegate dd= new SecurityServiceDelegate();
	//loginServiceDelegate d1= new loginServiceDelegate();
	public static Employer e=null;
	public static Worker w=null;
	public static String x="";
	public static String log="";
	public static String pass="";
	public static int id;
	 @FXML
	    public  JFXTextField login;
	    @FXML
	    public  JFXPasswordField pwd;

	    @FXML
	    private JFXButton l1;
	@FXML
	private Button l2;
	@FXML
	private Button exit;
	@FXML
	private Button forgot;
	public static User u=null;
	public static LoginContext loginContext;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
  @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, NamingException, NoSuchAlgorithmException {
//	  try{
//	  u1=delegate.doFindUserByLogin(login.getText());
//	  
//	  }catch(Exception e){
//		  
//	  }
	  
	  
//	  try{
//		  u=dd.doGetCnx(log, pass);
//		  Alert alert = new Alert(Alert.AlertType.INFORMATION);
//			 alert.setTitle("Welcome ");
//			 alert.setHeaderText(null);
//			 alert.setContentText("welcome "+u.getFirstName()+" "+u.getLastName()+" :)" );
//
//			 alert.showAndWait();
//			 id=u.getIdUser();
//
//		  Stage stage = (Stage) l1.getScene().getWindow();
//			 stage.close();
//		  if(u instanceof Worker){
//			 	Parent root = FXMLLoader.load(getClass().getResource("User2.fxml"));
//			 	Scene scene1 = new Scene(root);
//			 	stage.setScene(scene1);
//			 	stage.show();
//			 }else{
//			 	Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
//			 	Scene scene1 = new Scene(root);
//			 	stage.setScene(scene1);
//			 	stage.show();
//			 	}
//	  }catch(Exception e){
//		  Alert alert2 = new Alert(Alert.AlertType.WARNING);
//			alert2.setTitle("Wrong Informations ");
//			alert2.setHeaderText(null);
//			alert2.setContentText("check your Login Or your Password" );
//			alert2.showAndWait();
//	  }
	  log=login.getText();
	  pass=delegate.doCryte(pwd.getText());
	  User u=null;
	  // server log----
//	  System.setProperty("java.security.auth.login.config", "D:/pdevMalek/easyMission/easyMission-ejb/jaas.config");
//		LoginContext loginContext=null;
//		callbackHandler x=new callbackHandler();
//		x.setLogin(log);
//		x.setPwd(pass);
//		try {
//			 loginContext=new LoginContext("EM",x);
//			 System.out.println("ok1");
//			
//		} catch (LoginException e) {
//			
//			
//			//e.printStackTrace();
//			System.out.println(e.getMessage());
//			System.out.println("1");
//			System.exit(0);
//		}
//		try {
//			 loginContext.login();
//			 System.out.println("ok2");
//			 u=loginModule.u1;
//			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
//			 alert.setTitle("Welcome ");
//			 alert.setHeaderText(null);
//			 alert.setContentText("welcome "+u.getFirstName()+" "+u.getLastName()+" :)" );
//
//			 alert.showAndWait();
//			 id=u.getIdUser();
//
//
//			 Stage stage = (Stage) l1.getScene().getWindow();
//			 stage.close();
//
//			 if(u instanceof Worker){
//			 	Parent root = FXMLLoader.load(getClass().getResource("User2.fxml"));
//			 	Scene scene1 = new Scene(root);
//			 	stage.setScene(scene1);
//			 	stage.show();
//			 }else{
//			 	Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
//			 	Scene scene1 = new Scene(root);
//			 	stage.setScene(scene1);
//			 	stage.show();
//			 	}
//		} catch (LoginException e) {
//
//			Alert alert2 = new Alert(Alert.AlertType.WARNING);
//			alert2.setTitle("Wrong Informations ");
//			alert2.setHeaderText(null);
//			alert2.setContentText("check your Login Or your Password" );
//			alert2.showAndWait();
//			//}
//			System.out.println(e.getMessage());
//			System.out.println("2");
//		
//		}
		//client log---
	  System.setProperty("java.security.auth.login.config", "jaas.config");
		 loginContext=null;
		callbackHandler x=new callbackHandler();
		x.setLogin(log);
		x.setPwd(pass);
		try {
			 loginContext=new LoginContext("EM",x);
			 System.out.println("ok1");
			
		} catch (LoginException e) {
			
			
			//e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("1");
			System.exit(0);
		}
		try {
			 loginContext.login();
			 System.out.println("ok2");
			 u=loginModule.u1;
			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
			 alert.setTitle("Welcome ");
			 alert.setHeaderText(null);
			 alert.setContentText("welcome "+u.getFirstName()+" "+u.getLastName()+" :)" );

			 alert.showAndWait();
			 id=u.getIdUser();


			 Stage stage = (Stage) l1.getScene().getWindow();
			 stage.close();

			 if(u instanceof Worker){
			 	Parent root = FXMLLoader.load(getClass().getResource("User2.fxml"));
			 	Scene scene1 = new Scene(root);
			 	stage.setScene(scene1);
			 	stage.show();
			 }else{
			 	Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
			 	Scene scene1 = new Scene(root);
			 	stage.setScene(scene1);
			 	stage.show();
			 	}
		} catch (LoginException e) {

			Alert alert2 = new Alert(Alert.AlertType.WARNING);
			alert2.setTitle("Wrong Informations ");
			alert2.setHeaderText(null);
			alert2.setContentText("check your Login Or your Password" );
			alert2.showAndWait();
			//}
			System.out.println(e.getMessage());
			System.out.println("2");
		
		}
		
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
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		 alert.setTitle("Exit Attempt ");
		 alert.setHeaderText(null);
		 alert.setContentText("do you want to exit " );

		 //alert.showAndWait();
		 Stage stage = (Stage) l1.getScene().getWindow();
		 Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
         if (result.get() == javafx.scene.control.ButtonType.OK){
             System.exit(0);
         }

         if(result.get()==javafx.scene.control.ButtonType.CANCEL){
             alert.close();
         }
    	
	   // stage.close();
    }
    @FXML
    void forgot(ActionEvent event) throws IOException {
    	Stage stage = (Stage) l1.getScene().getWindow();
	    stage.close();
	    Parent root = FXMLLoader.load(getClass().getResource("pwdSMS.fxml"));
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
    	/*String nexmocmd =  "https://rest.nexmo.com/sms/json?api_key=542596a0&api_secret=84e0847c33281792&from=NEXMO&to="+216+num+"&text="+code;
        String response = executeGet(nexmocmd);
        if (response != null) {
            System.out.println("sent");
        } else {
           System.out.println("not sent");
        }*/
    }
   
}
