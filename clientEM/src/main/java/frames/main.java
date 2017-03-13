package frames;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class main extends Application{

	  @Override
	    public void start(Stage stage) throws Exception {
	        //Parent root = FXMLLoader.load(getClass().getResource("ReclamationManagement.fxml"));
		  //Parent root = FXMLLoader.load(getClass().getResource("AdminManagement.fxml"));
		//Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("BarChartSkills.fxml"));
		 //Parent root = FXMLLoader.load(getClass().getResource("RepportManagement.fxml"));
		 // Parent root = FXMLLoader.load(getClass().getResource("Chart1.fxml"));
		//  Parent root = FXMLLoader.load(getClass().getResource("ManageUsersWorkers.fxml"));
	        Scene scene = new Scene(root);
	        stage.initStyle(StageStyle.DECORATED);
	        stage.setScene(scene);
	        
	        stage.show();
	       
	    }
	  public static void main(String[] args) {
	        launch(args);
	    }
	    

}
