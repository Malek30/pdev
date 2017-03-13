package frames;

import entities.Repport;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.scene.control.TextArea;

import javafx.scene.layout.Pane;

public class ReclamationPaneController {
	
	public static Repport r ;
	private Repport rep;
	@FXML
	private Pane panereclamation;
	@FXML
	private TextField tfobject;
	@FXML
	private TextArea tftext;
	
	public void initialize()
	{
		rep=r ;
		tfobject.setText(r.getObject());
		tftext.setText(r.getText());
		
	}
	

}
