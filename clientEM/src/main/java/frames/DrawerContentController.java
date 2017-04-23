package frames;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.security.auth.login.LoginException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import security.loginModule;

public class DrawerContentController implements Initializable{
	  @FXML
	    private VBox box;

	    @FXML
	    private ImageView iv1;

	    @FXML
	    private JFXButton btn1;

	    @FXML
	    private JFXButton btn2;

	    @FXML
	    private JFXButton btn3;

	    @FXML
	    private JFXButton btn5;

	    @FXML
	    private JFXButton btn6;

	    @FXML
	    private JFXButton btn4;
	    @FXML
	    private JFXButton btn61;
	    @FXML
	    private JFXButton btn611;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

    @FXML
    void change(ActionEvent event) throws IOException {
    	JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        switch(btn.getText())
        {
            case "Home":
            	Stage stage2=new Stage();
                Parent root2 = FXMLLoader.load(getClass().getResource("User.fxml"));
                Scene scene11 = new Scene(root2);
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.setScene(scene11);
                stage2.show();
                Stage stage22 = (Stage) btn1.getScene().getWindow();
    		    stage22.close();

            
                break;
            case "Edit":
            	Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("EditEmployer.fxml"));
            Scene scene1 = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene1);
            stage.show();
            Stage stage1 = (Stage) btn1.getScene().getWindow();
		    stage1.close();
                break;
            case "Recommandation":
            	Stage stage3=new Stage();
                Parent root3 = FXMLLoader.load(getClass().getResource("RecommandationFRame.fxml"));
                Scene scene13 = new Scene(root3);
                stage3.initStyle(StageStyle.UNDECORATED);
                stage3.setScene(scene13);
                stage3.show();
                Stage stage14 = (Stage) btn1.getScene().getWindow();
    		    stage14.close();
                break;
          
        }
    }

    @FXML
    void exit(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		 alert.setTitle("Exit Attempt ");
		 alert.setHeaderText(null);
		 alert.setContentText("do you want to exit " );

		 //alert.showAndWait();
		 
		 Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
        if (result.get() == javafx.scene.control.ButtonType.OK){
        	System.exit(0);
        }

        if(result.get()==javafx.scene.control.ButtonType.CANCEL){
            alert.close();
        }
    	
    	

    }
    @FXML
    void addMission(ActionEvent event) throws IOException {
    	
    	Stage stage5=new Stage();
        Parent root5 = FXMLLoader.load(getClass().getResource("AddMSN.fxml"));
        Scene scene5 = new Scene(root5);
        stage5.initStyle(StageStyle.UNDECORATED);
        stage5.setScene(scene5);
        stage5.show();
        Stage stage51 = (Stage) btn1.getScene().getWindow();
	    stage51.close();
    }

 

   

    @FXML
    void mission(ActionEvent event) throws IOException {
    	Stage stage4=new Stage();
        Parent root4 = FXMLLoader.load(getClass().getResource("ManageMission.fxml"));
        Scene scene4 = new Scene(root4);
        stage4.initStyle(StageStyle.UNDECORATED);
        stage4.setScene(scene4);
        stage4.show();
        Stage stage41 = (Stage) btn1.getScene().getWindow();
	    stage41.close();
    }
    @FXML
    void SendMail(ActionEvent event) throws IOException {
    	Stage stage4=new Stage();
        Parent root4 = FXMLLoader.load(getClass().getResource("mail.fxml"));
        Scene scene4 = new Scene(root4);
        stage4.initStyle(StageStyle.UNDECORATED);
        stage4.setScene(scene4);
        stage4.show();
        Stage stage41 = (Stage) btn1.getScene().getWindow();
	    stage41.close();
    }
    @FXML
    void logout(ActionEvent event) throws IOException {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
  		 alert.setTitle("Logout Attempt ");
  		 alert.setHeaderText(null);
  		 alert.setContentText("do you want to logout " );

  		 //alert.showAndWait();
  		 
  		 Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
        if (result.get() == javafx.scene.control.ButtonType.OK){

        	loginModule l=new loginModule();
        	try {
        		Stage stage41 = (Stage) btn1.getScene().getWindow();
        	    stage41.close();
				frame1Controller.loginContext.logout();
	        	 Parent root = FXMLLoader.load(getClass().getResource("frame0.fxml"));
	         	Stage stage=new Stage();
	 	        Scene scene = new Scene(root);
	 	        stage.setResizable(false);
	 			stage.getIcons().add(new Image("http://icons.iconarchive.com/icons/ariil/alphabet/64/Letter-E-icon.png"));
	 			stage.setTitle("Easy Mission");
	 	        stage.initStyle(StageStyle.UNDECORATED);
	 	        stage.setScene(scene);
	 	        stage.show();
				
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
    }
    }


}
