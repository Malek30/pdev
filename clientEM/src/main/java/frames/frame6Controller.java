package frames;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXTextField;

import delegate.UserServiceDelegate;
import entities.Employer;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.UserServicesEJBRemote;

public class frame6Controller implements Initializable{
	UserServiceDelegate delegate= new UserServiceDelegate();
	public static Image image,image1;
	File picture=null;File picture1=null;
	  @FXML
	    private JFXTextField c;

	    @FXML
	    private JFXTextField cn;

	    @FXML
	    private JFXTextField ad;
	@FXML
	private Button pick;
	@FXML
	private Button pick1;
	@FXML
	private Button fill;
	@FXML
	private ImageView img;
	@FXML
	private ImageView img1;
	@FXML
    private Label companylabel;

    @FXML
    private Label numberlabel;

    @FXML
    private Label addresslabel;

    @FXML
    private Label logolabel;

    @FXML
    private Label imglabel;

    @FXML
    private Label fillLabel;
    public static boolean ok=false;

	// Event Listener on Button[#pick].onAction
	@FXML
	public void handleButton2Action(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
		picture = fileChooser.showOpenDialog(null);
		if (picture == null) {
			return;
		}
		try {
			BufferedImage bufferedImage = ImageIO.read(picture);
		 image = SwingFXUtils.toFXImage(bufferedImage, null);
			img.setImage(image);
                        
                        
		} catch (IOException ex) {
		}
                System.out.println(picture);
	}
	
	public static boolean isNum(String strNum) {
	    boolean ret = true;
	    try {

	        Double.parseDouble(strNum);

	    }catch (NumberFormatException e) {
	        ret = false;
	    }
	    return ret;
	}
	@FXML
	public void handleButton3Action(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
		picture1 = fileChooser.showOpenDialog(null);
		if (picture1 == null) {
			return;
		}
		try {
			BufferedImage bufferedImage = ImageIO.read(picture1);
		 image1 = SwingFXUtils.toFXImage(bufferedImage, null);
			img1.setImage(image1);
                        
                        
		} catch (IOException ex) {
		}
                System.out.println(picture1);
	}
	// Event Listener on Button[#fill].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) throws NamingException, IOException {
		Employer y=null;
		y=(Employer) delegate.doFindUserByName(frameW3Controller2.nn);
		Employer x=(Employer) delegate.doFindUserById(y.getIdUser());

//		if((ad.getText().equals(""))||(c.getText().equals(""))||(cn.getText().equals(""))||(picture.toString().equals(""))
//				||(picture1.toString().equals("")))
//		{
//			//||(isNum(cn.getText())==true)
//			Alert alert = new Alert(Alert.AlertType.INFORMATION);
//			alert.setTitle("Warning ");
//			alert.setHeaderText(null);
//			alert.setContentText(" fill All the Information");
//
//			alert.showAndWait();	
//		}else{
		x.setAdress(ad.getText());
		x.setCompany(c.getText());
		//if(isNum(cn.getText())==true){
		x.setCompanyNumber(cn.getText());
		//}
		//else{
//			Alert alert = new Alert(Alert.AlertType.INFORMATION);
//			alert.setTitle("Warning ");
//			alert.setHeaderText(null);
//			alert.setContentText(" fill a phone Number");
//
//			alert.showAndWait();
//		}
		x.setCompanyLogo(picture.toString());
		x.setPicture(picture1.toString());
		try {
		//	proxy.updateEmployer(x);
			delegate.doUpdateEmployer(x);
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Welcome ");
			alert.setHeaderText(null);
			alert.setContentText(" your Profile is now ready");

			alert.showAndWait();
			Stage stage = (Stage) c.getScene().getWindow();
		    stage.close();
		    
		    Parent root = FXMLLoader.load(getClass().getResource("frame1.fxml"));
	        Scene scene1 = new Scene(root);
	        stage.setScene(scene1);
	        stage.show();
			
		} catch (Exception E) {
			Alert alert22 = new Alert(Alert.AlertType.INFORMATION);
			alert22.setTitle("warning ");
			alert22.setHeaderText(null);
			alert22.setContentText("Please Fill all the fields" );

			alert22.showAndWait();
		}
		
		
		
		
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	  @FXML
	    void addressaction(MouseEvent event) {
		  if(ad.getText().equals("")){
	    		addresslabel.setText("please make sure you write your company address : it not obligatory");
	    	}else{
	    		addresslabel.setText("");
	    	}
	    }

	    @FXML
	    void fillaction(MouseEvent event) {
	    	if((cn.getText().equals(""))&&(picture1==null)){
	    		fillLabel.setText("make sure you fill the missing fields");
	    	}else{
	    		fillLabel.setText("");
	    		ok=true;
	    	}
	    	
	    }
	    @FXML
	    void imgaction(MouseEvent event) {
	    	if(picture1==null){
	    		imglabel.setText("make sure you pick your profile picture");
	    	}else{
	    		imglabel.setText("");
	    		
	    	}
	    }

	    @FXML
	    void logoaction(MouseEvent event) {
	    	if(picture==null){
	    		logolabel.setText("make sure you pick your company logo : it not obligatory");
	    	}else{
	    		logolabel.setText("");
	    		
	    	}

	    }

	    @FXML
	    void nameaction(MouseEvent event) {
	    	if(c.getText().equals("")){
	    		companylabel.setText("please make sure you write your company name : it not obligatory");
	    	}else{
	    		companylabel.setText("");
	    	}

	    }

	    @FXML
	    void numberaction(MouseEvent event) {
	    	if(isNum(cn.getText())==false){
	    		numberlabel.setText("make sure you write numbers");
	    	}else{
	    		numberlabel.setText("");
	    	}

	    }

}
