package frames;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.io.IOException;

import javax.naming.NamingException;

import com.sun.javafx.scene.control.skin.LabeledText;
import com.sun.javafx.scene.control.skin.TreeViewSkin;
import entities.Discussion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class AdminHomeController implements Initializable{
	@FXML
	private AnchorPane content;
	@FXML
	private TreeView<String> pane;
	@FXML
	private Label userName;
	@FXML
	private ImageView picture;
	
	@FXML
	private VBox vbox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pane.setRoot(getItems());	
        System.out.println("second");
		
	}

	private TreeItem getItems() {
		TreeItem<String> today = new TreeItem<>("Today");
    	TreeItem<String> stats = new TreeItem<String>("Statistics");
		
		TreeItem<String> location = new TreeItem<String>("Location");
		stats.getChildren().add(location);
		TreeItem<String> Domain = new TreeItem<String>("Domain");
		stats.getChildren().add(Domain);
		TreeItem<String> approve = new TreeItem<String>("Approves");
		stats.getChildren().add(approve);
		
		TreeItem<String> hello = new TreeItem<>("Tasks");
		
		
		hello.getChildren().add(today);
		
		TreeItem<String> mu = new TreeItem<>("Manage Users");
		TreeItem<String> exp = new TreeItem<>("Expertises");
		TreeItem<String> claims = new TreeItem<>("Claims");
		TreeItem<String> discussions = new TreeItem<>("Discussions");
		TreeItem<String> reports = new TreeItem<>("Reports");
		TreeItem<String> dis = new TreeItem<>("Reported Discussions");
		TreeItem<String> mandr = new TreeItem<>("Messages and replies");
		TreeItem<String> comments = new TreeItem<>("Comments");
		reports.getChildren().add(dis);
		reports.getChildren().add(mandr);
		reports.getChildren().add(comments);
		
		hello.setExpanded(false);
		hello.getChildren().add(mu);
		hello.getChildren().add(exp);
		hello.getChildren().add(claims);
		hello.getChildren().add(discussions);
		hello.getChildren().add(stats);
		hello.getChildren().add(reports);
		return hello;
    }

	}


