package frames;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl.Work;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import delegate.UserServiceDelegate;
import entities.Employer;
import entities.Skill;
import entities.Worker;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.UserServicesEJBRemote;
import javafx.scene.control.TextArea;

public class frame7Controller implements Initializable{
	
	UserServiceDelegate delegate= new UserServiceDelegate();
	public static ArrayList<Skill>skill=new ArrayList<>();
	public static ArrayList<Skill>skills=new ArrayList<>();
	public static Image image,image2;
	private  static ObservableList<Skill>data;
	private  static ObservableList<Skill>data1;
	File picture=null,picture2;
	  @FXML
	    private JFXTextField pn;

	    @FXML
	    private JFXTextField rib;

	    @FXML
	    private JFXTextArea d;

	    @FXML
	    private JFXComboBox<Skill> sk;
	@FXML
	private Button cv;
	@FXML
	private Button adsk;
	@FXML
	private Button fill;
	@FXML
	private Button pic;

	@FXML
	private ImageView img;
	@FXML
    private WebView web;
	@FXML
    private TableView<Skill> table;

    @FXML
    private TableColumn<Skill, String> skillname;
    @FXML
    private Label numberlabel;

    @FXML
    private Label desclabel;

    @FXML
    private Label bcnklabel;

    @FXML
    private Label imglabel;

    @FXML
    private Label skillslabel;

    @FXML
    private Label fillLabel;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		skills=(ArrayList<Skill>)delegate.dofindAllSkills();
		
		data =FXCollections.observableArrayList(skills);
		sk.getItems().addAll(data);
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
    private void handleButtonAction(ActionEvent event) throws IOException, NamingException {
		
		Worker y=(Worker) delegate.doFindUserByName(frameE4Controller.nn);
		Worker x=(Worker)delegate.doFindUserById(y.getIdUser());
		x.setPhoneNumber(pn.getText());
		x.setRib(rib.getText());
		x.setDescription(d.getText());
		x.setCv(picture2.toString());
		x.setPicture(picture.toString());
		x.setSkills(skill);
		
		if(pn.getText().equals("")){
    		fillLabel.setText("make sure you fill the empty fields");
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("Warning ");
    		alert.setHeaderText(null);
    		alert.setContentText(" please fill all the fields");

    		alert.showAndWait();
    	}else{
    		fillLabel.setText("");
		
		try {			
	    		delegate.doUpdateWorker(x);
	    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    		alert.setTitle("Welcome ");
	    		alert.setHeaderText(null);
	    		alert.setContentText(" your Profile is now ready");
	    		alert.showAndWait();
	    		Stage stage = (Stage) d.getScene().getWindow();
	    	    stage.close();
	    	    Parent root = FXMLLoader.load(getClass().getResource("frame1.fxml"));
	            Scene scene1 = new Scene(root);
	            stage.setScene(scene1);
	            stage.show();
			} catch (Exception E) {}
    	}
}
	@FXML
    private void handleButton2Action(ActionEvent event) throws IOException, NamingException {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilterPDF = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.PDF");
		fileChooser.getExtensionFilters().addAll(extFilterPDF);
		picture2 = fileChooser.showOpenDialog(null);
		System.out.println(picture2);
		String url =picture2.toString();
        web.setZoom(0.83);
        WebEngine we = web.getEngine();
        we.load(url);
        
		
		
	}
	
	@FXML
    private void handleButton3Action(ActionEvent event) throws IOException, NamingException {
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
	@FXML
    private void handleButton4Action(ActionEvent event) throws IOException, NamingException {
		data1=FXCollections.observableArrayList();
		skill.add(sk.getValue());
		ArrayList<Skill>lsk=skills;
		//Skill s1=delegate.doFindSkillByName(sk.getValue().toString());
		//System.out.println(s1.getName());
		lsk.removeAll(skill);
		
		
		data.clear();
		sk.getItems().clear();
		data =FXCollections.observableArrayList(lsk);
		sk.getItems().addAll(data);
		
//		for (Skill s : skills)
//		{
//		if(s.getName().equals(sk.getValue().toString())){
//			skills.remove(s);
//		}
//		}
		
		for (Skill s : skill)
		{
		data1.add(new Skill(s.getName()));
		}
		
		
//		table.setItems(data);
//		//skillname.setCellValueFactory( new PropertyValueFactory<Skill,String> (sk.getValue()));
//	skillname.setCellValueFactory((TableColumn.CellDataFeatures<Skill, String> t)
//            -> new SimpleStringProperty(sk.getValue().toString()));
		
table.setItems(data1);
	skillname.setCellValueFactory( new PropertyValueFactory<Skill,String> ("name"));
}
	 @FXML
	    void bankaction(MouseEvent event) {
		 if(rib.getText().equals("")){
			 bcnklabel.setText("make sure you feel your bank information");
		 }else{
			 bcnklabel.setText("");
		 }
	    }

	    @FXML
	    void descaction(MouseEvent event) {
	    	if(d.getText().equals("")){
				 desclabel.setText("make sure you feel description input");
			 }else{
				 desclabel.setText("");
			 }
		    
	    }
	    @FXML
	    void imgaction(MouseEvent event) {
	    	if(picture==null){
				 imglabel.setText("make sure you import a profile picture");
			 }else{
				 imglabel.setText("");
			 }
	    }

	    @FXML
	    void phoneaction(MouseEvent event) {
	    	if(isNum(pn.getText())==false){
	    		numberlabel.setText("make sure you write your phone number");
	    		
	    	}else{
	    		numberlabel.setText("");
	    		
	    	}

	    }

	    @FXML
	    void skillaction(MouseEvent event) {

	    }
	    @FXML
	    void fillaction(MouseEvent event) {
	    	if((pn.getText().equals(""))&&(rib.getText().equals(""))&&(d.getText().equals(""))&&(picture==null)){
	    		fillLabel.setText("make sure you fill the empty fields");
	    	}else{
	    		fillLabel.setText("");
	    	}

	    }


		
		
	
}
