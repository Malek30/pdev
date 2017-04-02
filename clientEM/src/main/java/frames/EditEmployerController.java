package frames;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import delegate.UserServiceDelegate;
import entities.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.UserServicesEJBRemote;

public class EditEmployerController implements Initializable{
	UserServiceDelegate delegate= new UserServiceDelegate();
	  @FXML
	    private AnchorPane ap;

	    @FXML
	    private ImageView iv;

	    @FXML
	    private JFXHamburger ham;

	    @FXML
	    private JFXDrawer drawer;

	    @FXML
	    private ImageView ppic;

	    @FXML
	    private WebView map;

	    @FXML
	    private ImageView cpic;

	    @FXML
	    private Button btpic;

	    @FXML
	    private Button btlogo;

	    @FXML
	    private Button update;

	    @FXML
	    private JFXTextField firstname;

	    @FXML
	    private JFXTextField lastname;

	    @FXML
	    private JFXTextField email;

	    @FXML
	    private JFXTextField address;

	    @FXML
	    private JFXTextField cname;

	    @FXML
	    private JFXTextField cnumber;

	    @FXML
	    private JFXComboBox field;

	    @FXML
	    private JFXDatePicker bdate;
	    @FXML
	    private Label fnamelabel;

	    @FXML
	    private Label lnamelabel;

	    @FXML
	    private Label emailabel;

	    @FXML
	    private Label fieldlabel;

	    @FXML
	    private Label datelabel;

	    @FXML
	    private Label addresslabel;

	    @FXML
	    private Label cnamelabel;

	    @FXML
	    private Label cnumlabel;
	    public static Employer emp;
    public static Image image,image1;
    File picture,picture1;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		field.getItems().addAll(
	            "Mecanique",
	            "Informatique",
	            "Design",
	            "ART",
	            "Other");
		try {
			VBox box =FXMLLoader.load(getClass().getResource("DrawerContent.fxml"));
			drawer.setSidePane(box);
			
		
    	
    	HamburgerBackArrowBasicTransition burgertask = new HamburgerBackArrowBasicTransition(ham);
    	burgertask.setRate(-1);
    	ham.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) ->{
    		burgertask.setRate(burgertask.getRate() * -1);
    		burgertask.play();
    		if(drawer.isShown())
            {
                drawer.close();
            }else
                drawer.open();
    		
    		
    	
    	}
    	);
    }catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
				 emp=delegate.doFindEmployerById(frame1Controller.id);
				//Employer emp=proxy.findEmploerById(frame1Controller.id);
				firstname.setPromptText(emp.getFirstName());
				lastname.setPromptText(emp.getLastName());
				email.setPromptText(emp.getEmail());
//				Date d=new Date(emp.getBirthDate());
//				DatePicker d1=new DatePicker(emp.getBirthDate());
				bdate.setPromptText(emp.getBirthDate());
				address.setPromptText(emp.getAdress());
				cname.setPromptText(emp.getCompany());
				cnumber.setPromptText(emp.getCompanyNumber());
				field.setPromptText(emp.getField());
				picture=new File(emp.getCompanyLogo());
		        picture1=new File(emp.getPicture());
		        BufferedImage bufferedImage = null;
		        BufferedImage bufferedImage1 = null;
				try {
					bufferedImage = ImageIO.read(picture);
					bufferedImage1 = ImageIO.read(picture1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 image = SwingFXUtils.toFXImage(bufferedImage, null);
				 image1 = SwingFXUtils.toFXImage(bufferedImage1, null);
					cpic.setImage(image);
					ppic.setImage(image1);

				 String url ="https://www.google.tn/maps/place/"+emp.getAdress();
			        map.setZoom(0.83);
			        WebEngine we = map.getEngine();
			        we.load(url);
	}
    @FXML
    void exit(ActionEvent event) {
    	Stage stage = (Stage) ap.getScene().getWindow();
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		 alert.setTitle("Exit Attempt ");
		 alert.setHeaderText(null);
		 alert.setContentText("do you want to exit " );

		 //alert.showAndWait();
		 
		 Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
        if (result.get() == javafx.scene.control.ButtonType.OK){
            stage.close();
        }

        if(result.get()==javafx.scene.control.ButtonType.CANCEL){
            alert.close();
        }
    }
    @FXML
    void changeLogo(ActionEvent event) {
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
			cpic.setImage(image);
                        
                        
		} catch (IOException ex) {
		}
                System.out.println(picture);

    }

    @FXML
    void changePic(ActionEvent event) {
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
			ppic.setImage(image1);
                        
                        
		} catch (IOException ex) {
		}
                System.out.println(picture);
    }

    @FXML
    void update(ActionEvent event) throws IOException, NamingException {
    	
    	Employer emp=delegate.doFindEmployerById(frame1Controller.id);
		if(firstname.getText().equals("")){
			String fn=emp.getFirstName();
			emp.setFirstName(fn);
		}else{
			emp.setFirstName(firstname.getText());	
		}
		
		if(lastname.getText().equals("")){
			String ln=emp.getLastName();
			emp.setLastName(ln);
		}else{
			emp.setLastName(lastname.getText());
		}
		
		if(email.getText().equals("")){
			String em=emp.getEmail();
			emp.setEmail(em);
		}else{
			emp.setEmail(email.getText());
		}
		
		if(field.getValue()==null){
			String f=emp.getField();
			emp.setField(f);
		}else{
			emp.setField(field.getValue().toString());
		}
		
		if(bdate.getValue()==null){
			String BD=emp.getBirthDate();
			emp.setBirthDate(BD);
		}else{
			emp.setBirthDate(bdate.getValue().toString());
		}
		
		if(address.getText().equals("")){
			String ad=emp.getAdress();
			emp.setAdress(ad);
		}else{
			emp.setAdress(address.getText());
		}
		
		if(cname.getText().equals("")){
			String ad=emp.getCompany();
			emp.setCompany(ad);
		}else{
			emp.setCompany(cname.getText());
		}
		
		if(cnumber.getText().equals("")){
			String ad=emp.getCompanyNumber();
			emp.setCompanyNumber(ad);
		}else{
			emp.setCompanyNumber(cnumber.getText());
		}
		
		if(picture.toString().equals("")){
			String ad=emp.getCompanyLogo();
			emp.setCompanyLogo(ad);
		}else{
			emp.setCompanyLogo(picture.toString());
		}
		
		if(picture1.toString().equals("")){
			String ad=emp.getPicture();
			emp.setPicture(ad);
		}else{
			emp.setPicture(picture1.toString());
		}
		//System.out.println("1"+field.getValue().toString());
		//System.out.println("2"+bdate.getValue().toString());
		//proxy.updateEmployer(emp);
		
		delegate.doUpdateEmployer(emp);
		
    	Stage stage = (Stage) cname.getScene().getWindow();
	    stage.close();
	    Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
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
    @FXML
    void emailaction1(MouseEvent event) {
    	emailabel.setText("make sure before you change the email");
    	

    }
    @FXML
    void emailaction(MouseEvent event) {
    	if(email.getText().equals("")){
    		emailabel.setText("");
    	}else{
    	if(isEmail(email.getText())==false){
    		emailabel.setText("email is invalid");
    	}else{
    		emailabel.setText("");
    		email.setPromptText(email.getText());
    	}}
    }
    @FXML
    void fieldaction(MouseEvent event) {
    	if(field.getPromptText().equals(emp.getField())){
    	fieldlabel.setText("");}

    }
    @FXML
    void fieldaction1(MouseEvent event) {
    	fieldlabel.setText("make sure before you change your field");
    }

    @FXML
    void fnameaction(MouseEvent event) {
    	if(firstname.getText().equals("")){
    		fnamelabel.setText("");
    	}else{
    		if(isAlpha(firstname.getText())==false){
    			fnamelabel.setText("make sure you write text");
    		}else{
    			fnamelabel.setText("");
    			firstname.setPromptText(firstname.getText());
    		}}
    	

    }
    @FXML
    void fnameaction1(MouseEvent event) {
    	fnamelabel.setText("make sure before you change your first name");
    }

    @FXML
    void lnameaction(MouseEvent event) {
    	if(lastname.getText().equals("")){
    		lnamelabel.setText("");
    	}else{
    		if(isAlpha(firstname.getText())==false){
    			lnamelabel.setText("make sure you write text");
    		}else{
    			lnamelabel.setText("");
    			lastname.setPromptText(lastname.getText());
    		}}
    	
    }
    @FXML
    void lnameaction1(MouseEvent event) {
    	lnamelabel.setText("make sure before you change your last name");
    }
    @FXML
    void dateaction(MouseEvent event) {
    	if(bdate.getPromptText().equals(emp.getBirthDate())){
    		datelabel.setText("");
    	}else{
    		bdate.setPromptText(bdate.getValue().toString());
    	}
    }
    @FXML
    void dateaction1(MouseEvent event) {
    	datelabel.setText("make sure before you chage your birthdate");
    }
    @FXML
    void addressaction(MouseEvent event) {
    	if(address.getText().equals("")){
    		addresslabel.setText("");
    	}else{
    		address.setPromptText(address.getText());
    	}

    }

    @FXML
    void addressaction1(MouseEvent event) {
    	addresslabel.setText("make sure before you change you company address");
    }


    @FXML
    void cnameaction(MouseEvent event) {
    	if(cname.getText().equals("")){
    		cnamelabel.setText("");
    	}else{
    		cname.setPromptText(cname.getText());
    	}
    	

    }

    @FXML
    void cnameaction1(MouseEvent event) {
    	cnamelabel.setText("make sure before you change you company name");

    }

    @FXML
    void cnumaction(MouseEvent event) {
    	if(cnumber.getText().equals("")){
    		cnumlabel.setText("");
    	}else{
    		
    		if(isNum(cnumber.getText())==false){
    			cnumlabel.setText("make sure you write numeric");
    		}else{
    			cnumlabel.setText("");
    			cnumber.setPromptText(cnumber.getText());
    		}
    	}
    }

    @FXML
    void cnumaction1(MouseEvent event) {
    	cnumlabel.setText("make sure before you change your company number");
    }


}
