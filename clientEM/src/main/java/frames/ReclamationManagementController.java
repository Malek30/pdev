package frames;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Repport;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import services.AdminserviceEJBRemote;

public class ReclamationManagementController implements Initializable{
	@FXML
	private VBox vbox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		InitialContext ic;
		try {
			vbox.getChildren().clear();
			ic = new InitialContext();
			AdminserviceEJBRemote proxy = (AdminserviceEJBRemote) ic.lookup("/easyMission-ear/easyMission-ejb/"
					+ "AdminserviceEJB!services.AdminserviceEJBRemote");
			List<Repport> listreports = proxy.displayholdingReclmations();
			for (Repport r : listreports)
			{
				AnchorPane a = (AnchorPane)FXMLLoader.load(getClass().getResource("ReclamationPane.fxml"));
				vbox.getChildren().add(a);
			}
			
		} catch (NamingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
