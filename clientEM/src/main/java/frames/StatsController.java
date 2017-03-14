package frames;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class StatsController implements Initializable{
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private TreeView<String> treeview;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TreeItem<String> root = new TreeItem<String>("Statistics");
		 
		 root.getChildren().addAll(
		     new TreeItem<String>("stats1"),
		     new TreeItem<String>("stats2"),
		     new TreeItem<String>("stats3")
		 );
		  
		  treeview.setRoot(root);
		
	}
	

}
