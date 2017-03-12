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
	        Parent root = FXMLLoader.load(getClass().getResource("frame1.fxml"));
	        
	        Scene scene = new Scene(root);
	        stage.initStyle(StageStyle.UNDECORATED);
	        stage.setScene(scene);
	        stage.show();
	       
	    }
	  public static void main(String[] args) {
	        launch(args);
	    }
	    

}
