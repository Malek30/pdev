package frames;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import security.callbackHandler;


public class main extends Application{

	  @Override
	    public void start(Stage stage) throws Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("frame1.fxml"));
	        
	        Scene scene = new Scene(root);
	        stage.setResizable(false);
			stage.getIcons().add(new Image("http://icons.iconarchive.com/icons/ariil/alphabet/64/Letter-E-icon.png"));
			stage.setTitle("Easy Mission");
	        stage.initStyle(StageStyle.UNDECORATED);
	        stage.setScene(scene);
	        stage.show();
	       
	    }
	  public static void main(String[] args) {
	        launch(args);/*
	        System.setProperty("java.security.auth.login.config", "jaastutorial.config");
			LoginContext loginContext=null;
			try {
				 loginContext=new LoginContext("ZaJaasTutorial",new ZaCallbackHandler());
			} catch (LoginException e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
				System.exit(0);
			}
			while(true){
				try {
					loginContext.login();
					System.exit(0);
				} catch (LoginException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}*/
		}
	    }
	    


