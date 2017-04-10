package frames;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

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

public class DrawerContentController2 implements Initializable{

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
    private JFXButton btn31;

    @FXML
    private JFXButton btn4;

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
                Parent root2 = FXMLLoader.load(getClass().getResource("User2.fxml"));
                Scene scene11 = new Scene(root2);
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.setScene(scene11);
                stage2.show();
                Stage stage22 = (Stage) btn1.getScene().getWindow();
    		    stage22.close();

            
                break;
            case "Logout":
            	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       		 alert.setTitle("Logout Attempt ");
       		 alert.setHeaderText(null);
       		 alert.setContentText("do you want to exit " );

       		 //alert.showAndWait();
       		 
       		 Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
             if (result.get() == javafx.scene.control.ButtonType.OK){
            	 Parent root = FXMLLoader.load(getClass().getResource("frame1.fxml"));
            	 Stage stage=new Stage();
     	        Scene scene = new Scene(root);
     	        stage.setResizable(false);
     			stage.getIcons().add(new Image("http://icons.iconarchive.com/icons/ariil/alphabet/64/Letter-E-icon.png"));
     			stage.setTitle("Easy Mission");
     	        stage.initStyle(StageStyle.UNDECORATED);
     	        stage.setScene(scene);
     	        stage.show();
                
           	 
             }

             if(result.get()==javafx.scene.control.ButtonType.CANCEL){
                 alert.close();
             }
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
    void msearch(ActionEvent event) throws IOException {
    	Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../gui/lookForMission.fxml"));
        Scene scene1 = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene1);
        stage.show();
        Stage stage1 = (Stage) btn1.getScene().getWindow();
	    stage1.close();

    }

    @FXML
    void myMission(ActionEvent event) throws IOException {
    	Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../gui/workerMissions.fxml"));
        Scene scene1 = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene1);
        stage.show();
        Stage stage1 = (Stage) btn1.getScene().getWindow();
	    stage1.close();
    }
    @FXML
    void edit(ActionEvent event) throws IOException {
    	
      
      
      Stage stage=new Stage();
      Parent root = FXMLLoader.load(getClass().getResource("EditWorker.fxml"));
      Scene scene1 = new Scene(root);
      stage.initStyle(StageStyle.UNDECORATED);
      stage.setScene(scene1);
      stage.show();
      Stage stage1 = (Stage) btn1.getScene().getWindow();
	    stage1.close();

    }



}
