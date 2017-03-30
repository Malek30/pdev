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
import com.jfoenix.controls.JFXDialogLayout;
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
import entities.User;
import entities.Worker;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class frameE4Controller implements Initializable{
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
    @FXML
    private Label fnlabel;

    @FXML
    private Label lnlabel;

    @FXML
    private Label emailabel;

    @FXML
    private Label countrylabel;

    @FXML
    private Label fieldlabel;

    @FXML
    private Label loginlabel;

    @FXML
    private Label genderlabel;

    @FXML
    private Label datelabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label rpwdlabel;
    @FXML
    private Label registerlabel;
    public static boolean ok=false;

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
    public static boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
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
    	
    
    	Worker e=new Worker();
		e.setBirthDate(date.getValue().toString());
		e.setCountry(coutry.getValue().toString());
		coutry.setPromptText(coutry.getValue().toString());
		e.setField(field.getValue().toString());
		e.setFirstName(fn.getText());
		e.setLastName(ln.getText());
		e.setLogin(login.getText());
		e.setEmail(email.getText());
		e.setPassword(pwd.getText());
		e.setState("active");
		
		try {
			//proxy.addEmployer(e);
			if(ok==true){
			delegate.doAddWorker(e);
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
			
		} catch (Exception E) {
			Alert alert21 = new Alert(Alert.AlertType.INFORMATION);
			alert21.setTitle("Wrong Informations ");
			alert21.setHeaderText(null);
			alert21.setContentText("Fill all the fields" );

			alert21.showAndWait();
		}
		
		
		
		
		
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
    @FXML
    void EmailAction(MouseEvent event) {
    	if(isEmail(email.getText())==false){
    		emailabel.setText("email is invalid");
    	}else{
    		emailabel.setText("");
    	}
    	User e=null;
    	try{
    	e= delegate.doFindUserByMail(email.getText());
    	}
    	catch(Exception E){}
    	//System.out.println("true "+e.getFirstName());
    	if(e!=null){
    	if(e.getEmail().equals(email.getText())){
    		emailabel.setText("Email already exist");
    	}else{
    		emailabel.setText("");
    	}}
    	
    }

    @FXML
    void LoginAction(MouseEvent event) {
    	field.setPromptText(field.getValue().toString());
    	User e=null;
    	try{
    	e= delegate.doFindUserByLogin(login.getText());}
    	catch(Exception E){}
    	if(e!=null){
    	if(e.getLogin().equals(login.getText())){
    		loginlabel.setText("Login already exist");	
    	}else{
    		loginlabel.setText("");
    	}
    	}else{
    		loginlabel.setText("");
    	}
    	

    }



    @FXML
    void firstNameAction(MouseEvent event) {

    	if(isAlpha(fn.getText())==false){
    		fnlabel.setText("please make sure you type text");
			}else{
				fnlabel.setText("");
			}
    	

    }

  

    @FXML
    void lastNameAction(MouseEvent event) {
    	if(isAlpha(ln.getText())==false){
    		lnlabel.setText("please make sure you type text");
			}else{
				lnlabel.setText("");
			}
    }

    @FXML
    void passwordAction(MouseEvent event) {
    	date.setPromptText(date.getValue().toString());
//    	
//    	if(pwd.getText().length()<=5){
//    		passwordLabel.setText("password is soo predictable");
//    	}

    }
    @FXML
    void RetypePasswordAction(MouseEvent event) {
    	if(pwd.getText().equals(rpwd.getText())){
    		rpwdlabel.setText("");
    		
    	}
    	else{
    		rpwdlabel.setText("make sure you retype the same password");
    	}
    }

    @FXML
    void registerBt(MouseEvent event) {
    	
    	
    	
    	
    	if((fn.getText().equals(""))&&(ln.getText().equals(""))&&(email.getText().equals(""))&&(login.getText().equals(""))
    			&&(pwd.getText().equals(""))&&(rpwd.getText().equals(""))){
    		registerlabel.setText("Make sure you fill all the inputs");
    		//&&(genderlabel.getText().equals("please make sure you select your gender"))&&(fieldlabel.getText().equals("please make sure you select your field"))
			//&&(datelabel.getText().equals("please make sure you select your date of birth"))&&(countrylabel.getText().equals("please make sure you select your coutry"))
    	}else{
    		registerlabel.setText("");
    		ok=true;
    	}

    }
    @FXML
    void countryaction(MouseEvent event) {
//    	coutry.setPromptText(coutry.getValue().toString());
    	if(coutry.getPromptText().equals("Country")){
    		countrylabel.setText("please make sure you select your coutry");
    		
    	}else{
    	
        	//coutry.setPromptText(coutry.getValue().toString());
    		countrylabel.setText("");
    	}
    	
    	//System.out.println("test"+coutry.getPromptText());
    	
    	//System.out.println("test"+coutry.getPromptText());
    }

    @FXML
    void dateaction(MouseEvent event) {
    	gender.setPromptText(gender.getValue().toString());
    	if(date.getPromptText().equals("Date of birth")){
    		datelabel.setText("please make sure you select your date of birth");
    		
    	}else{
    		
        	//date.setPromptText(date.getValue().toString());
        	
    		datelabel.setText("");
    	}
    }

    @FXML
    void fieldaction(MouseEvent event) {
    	coutry.setPromptText(coutry.getValue().toString());
    	if(field.getPromptText().equals("Field")){
    		fieldlabel.setText("please make sure you select your field");
    		
    	}else{
    		
//        	field.setPromptText(field.getValue().toString());
    		fieldlabel.setText("");
    	}
    	

    }
    @FXML
    void genderaction(MouseEvent event) {
    	if(gender.getPromptText().equals("Gender")){
    		genderlabel.setText("please make sure you select your gender");
    		
    	}else{
//    		gender.setPromptText(gender.getValue().toString());
        	
    		genderlabel.setText("");
    	}
    }

   
}
