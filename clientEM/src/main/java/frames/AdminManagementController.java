package frames;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Employer;
import entities.Mission;
import entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.AdminserviceEJBRemote;
import javafx.scene.control.TableColumn;

public class AdminManagementController implements Initializable{
	ObservableList<Mission> data;
	@FXML
	private Label lbmission;
	@FXML
	private TableView <Mission>tablemission;
	@FXML
	private TableColumn<Mission,Integer> id;
	@FXML
	private TableColumn <Mission,String>title;
	@FXML
	private TableColumn<Mission,String>description;
	@FXML
	private TableColumn<Mission,String> type;
	@FXML
	private TableColumn<Mission,Float> price;
	@FXML
	private TableColumn<Mission,String> skills;
	@FXML
	private TableColumn<Mission,String> state;
	@FXML
	private TableColumn<Mission,String> field;
	
	@FXML
	private Button btnvalidate;
	@FXML
	private TextField tfstate;
	@FXML
	private TextField tffield;
	@FXML
	private TextField tftype;

	// Event Listener on Button[#btnvalidate].onAction
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			 InitialContext	ic = new InitialContext();
				
			AdminserviceEJBRemote proxy = (AdminserviceEJBRemote) ic.lookup("/easyMission-ear/easyMission-ejb"
					+ "/AdminserviceEJB!services.AdminserviceEJBRemote");
		
		List<Mission>  elist = proxy.displayallmissions();
		data=FXCollections.observableArrayList();
			for (Mission ms :elist)
				
			{
				data.add(new Mission(ms.getIdMission(),ms.getTitle(),ms.getDescription(),ms.getSkills(),ms.getField(),ms.getPrice(),ms.getState(),ms.getMissionType()));
			}
			
			tablemission.setItems(data);
			id.setCellValueFactory(new PropertyValueFactory<Mission, Integer>("idMission"));
			title.setCellValueFactory(new PropertyValueFactory<Mission, String>("title"));
			description.setCellValueFactory(new PropertyValueFactory<Mission, String>("description"));
			type.setCellValueFactory(new PropertyValueFactory<Mission, String>("missionType"));
			price.setCellValueFactory(new PropertyValueFactory<Mission, Float>("price"));
			skills.setCellValueFactory(new PropertyValueFactory<Mission, String>("skills"));
			state.setCellValueFactory(new PropertyValueFactory<Mission, String>("state"));
			field.setCellValueFactory(new PropertyValueFactory<Mission, String >("field"));
			
			
		 } catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		setcellvaluefromrabletotextfield ();
		
		
	}
	
	
	public void setcellvaluefromrabletotextfield ()
	{
		tablemission.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				
				Mission m = tablemission.getItems().get(tablemission.getSelectionModel().getSelectedIndex());
				
			    tfstate.setText(m.getState());
				tftype.setText(m.getMissionType());
				tffield.setText(m.getField());
		
				
			}
		});
	}
	@FXML
	public void validermission(ActionEvent event) {
		/*
		btnvalidate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
try {
	InitialContext ic2 = new InitialContext();
	AdminserviceEJBRemote proxy2 = (AdminserviceEJBRemote) ic2.lookup("/easyMission-ear/easyMission-ejb/"
			+ "AdminserviceEJB!services.AdminserviceEJBRemote");
	
	
	Mission m = tablemission.getItems().get(tablemission.getSelectionModel().getSelectedIndex());
	System.out.println("state "+m.getState());
	if(m.getState()=="attente")
	{
	proxy2.validatemission(m);
	
	}
	else
	{
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EASY MISSION");
        alert.setHeaderText(null);
        alert.setContentText("Mission already activated");
	}
	
}
catch (NamingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
		});
				
*/
	
		/*try {
			InitialContext ic2 = new InitialContext();
			AdminserviceEJBRemote proxy2 = (AdminserviceEJBRemote) ic2.lookup("/easyMission-ear/easyMission-ejb/"
					+ "AdminserviceEJB!services.AdminserviceEJBRemote");
			
			
			Mission m = tablemission.getItems().get(tablemission.getSelectionModel().getSelectedIndex());
			System.out.println("id "+m.getIdMission());
			System.out.println("state "+m.getState());
			proxy2.findmissionbyId(m.getIdMission());
			proxy2.validatemission(m);
			
		} catch (NamingException e)
		{
			e.printStackTrace();
		}*/
} 
				
				
				
		
	}
	

