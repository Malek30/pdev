package frames;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.UserServicesEJBRemote;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.omg.CosNaming.IstringHelper;

import delegate.UserServiceDelegate;
import entities.Employer;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;

public class frameW3Controller2 implements Initializable{
	UserServiceDelegate delegate= new UserServiceDelegate();
	public static String nn;
    @FXML
    private JFXTextField fn;

    @FXML
    private JFXComboBox coutry;

    @FXML
    private Button add;

    @FXML
    private Button back;

    @FXML
    private JFXTextField ln;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXComboBox field;

    @FXML
    private JFXTextField login;

    @FXML
    private JFXComboBox gender;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXPasswordField pwd;

    @FXML
    private JFXPasswordField rpwd;
    public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\\\\\+]+(\\.[\\w\\\\]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }
	@Override
    public void initialize(URL url, ResourceBundle rb) {
		coutry.getItems().addAll(
	            "Usa",
	            "Canada",
	            "Tunisia",
	            "Italie",
	            "Germany");
	    
	field.getItems().addAll(
			"IT",
            "Mecanique",
            "Informatique",
            "Design",
            "ART",
            "Other");
	gender.getItems().addAll(
            "Male",
            "Female"
            );
    }
       
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, NamingException {
    	
    	//------serveur cnx---------
    	/*InitialContext ctx=new InitialContext();
		Object objet=ctx.lookup("/easyMission-ear/easyMission-ejb/UserServicesEJB!services.UserServicesEJBRemote");
		UserServicesEJBRemote proxy=(UserServicesEJBRemote)objet;*/
		//------------
		Employer e=new Employer();
		Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
		alert2.setTitle("missing fiels");
		alert2.setHeaderText(null);
		alert2.setContentText("fill fields" );

		
		e.setBirthDate(date.getValue().toString());
		e.setCountry(coutry.getPromptText());
		e.setField(field.getValue().toString());
		if(fn.getText().equals("")){
			alert2.showAndWait();
		}else{
		e.setFirstName(fn.getText());}
		
		if(ln.getText().equals("")){
			alert2.showAndWait();
		}else{
		e.setLastName(ln.getText());
		}
		if(login.getText().equals("")){
			alert2.showAndWait();
		}else{
		e.setLogin(login.getText());}
		if(email.getText().equals("")){
			alert2.showAndWait();
		}else{
			if(isEmail(email.getText())==true){
			e.setEmail(email.getText());}
			else{
				Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
				alert1.setTitle("Wrong Email");
				alert1.setHeaderText(null);
				alert1.setContentText("Email is not valid" );
				alert1.showAndWait();
			}
		}
		if(pwd.getText().equals("")){
			alert2.showAndWait();
		}else{
			if(pwd.getText().equals(rpwd.getText()))
			e.setPassword(pwd.getText());
			else{
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Passwords are not the same");
				alert.setHeaderText(null);
				alert.setContentText("retype the correct Password" );
				alert.showAndWait();
			}
		}
		
		
		
		e.setState("active");
		//e.setType("employer");
		try {
			//proxy.addEmployer(e);
			delegate.doAddEmployer(e);
			
		} catch (Exception E) {
			Alert alert21 = new Alert(Alert.AlertType.INFORMATION);
			alert21.setTitle("Wrong Informations ");
			alert21.setHeaderText(null);
			alert21.setContentText("Fill all the fields" );

			alert21.showAndWait();
		}
		
		
		
		nn=fn.getText();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Welcome ");
		alert.setHeaderText(null);
		alert.setContentText("welcome "+ln.getText()+" "+fn.getText()+" :)" );

		alert.showAndWait();
		Stage stage = (Stage) add.getScene().getWindow();
	    stage.close();
	    Parent root = FXMLLoader.load(getClass().getResource("frame5.fxml"));
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
		
    }
    @FXML
    private void handle2ButtonAction(ActionEvent event) throws IOException, NamingException {
    	Stage stage = (Stage) add.getScene().getWindow();
	    stage.close();
	    Parent root = FXMLLoader.load(getClass().getResource("frame2.fxml"));
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
    }
   
}
