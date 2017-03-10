package frames;

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
import java.util.Date;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Employer;
import entities.Worker;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;

public class frameE4Controller implements Initializable{
	public static String nn;
	@FXML
	private TextField fn;
	@FXML
	private TextField ln;
	@FXML
	private TextField email;
	@FXML
	private DatePicker date;
	@FXML
	private TextField rpwd;
	@FXML
	private TextField pwd;
	@FXML
	private ComboBox coutry;
	@FXML
	private Button add;
	@FXML
	private ComboBox gender;
	@FXML
	private ComboBox field;
	@FXML
	private Button back;

	@Override
    public void initialize(URL url, ResourceBundle rb) {
		coutry.getItems().addAll(
	            "Usa",
	            "Canada",
	            "Tunisia",
	            "Italie",
	            "Germany");
	    
	field.getItems().addAll(
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
    	InitialContext ctx=new InitialContext();
		Object objet=ctx.lookup("/easyMission-ear/easyMission-ejb/UserServicesEJB!services.UserServicesEJBRemote");
		UserServicesEJBRemote proxy=(UserServicesEJBRemote)objet;
		Worker e=new Worker();
		e.setBirthDate(date.getPromptText());
		e.setCountry(coutry.getPromptText());
		e.setField(field.getPromptText());
		e.setFirstName(fn.getText());
		e.setLastName(ln.getText());
		e.setLogin(ln.getText());
		e.setEmail(email.getText());
		e.setPassword(pwd.getText());
		e.setState("active");
		proxy.addWorker(e);
		nn=fn.getText();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Welcome ");
		alert.setHeaderText(null);
		alert.setContentText("welcome "+ln.getText()+" "+fn.getText()+" :)" );

		alert.showAndWait();
		Stage stage = (Stage) add.getScene().getWindow();
	    stage.close();
	    Parent root = FXMLLoader.load(getClass().getResource("frame51.fxml"));
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
