package frames;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Repport;
import entities.User;
import entities.Worker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.AdminserviceEJBRemote;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class RepportManagementController implements Initializable {
	ObservableList<Repport> dataRp;
	ObservableList<Repport> datatRpt;
	@FXML
	private Label labeladmin;
	@FXML
	private ImageView iv1;
	@FXML
	private Label labelreports;
	@FXML
	private TableView<Repport> tablerepports;
	@FXML
	private TableColumn<Repport,String> columnobject;
	@FXML
	private TableColumn<Repport,String> columntext;
	@FXML
	private TableColumn<Repport,String> columnstate;
	@FXML
	private TableColumn <Repport,String>columnreporter;
	@FXML
    private Button btnaccept;
	@FXML
    private Button btnrefresh;
    @FXML
    private Button btndecline;

    @FXML
    private TableView<Repport> tableuntraitedreports;

    @FXML
    private TableColumn<Repport, String> tobject;

    @FXML
    private TableColumn<Repport, String> ttest;

    @FXML
    private TableColumn<Repport, String> tstate;

    @FXML
    private TableColumn<Repport, String> treporter;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			 InitialContext	ic = new InitialContext();
				
			AdminserviceEJBRemote proxy = (AdminserviceEJBRemote) ic.lookup("/easyMission-ear/easyMission-ejb/"
					+ "AdminserviceEJB!services.AdminserviceEJBRemote");
		
		List<Repport>  elistR = proxy.displayholdingReclmations();
		List<Repport> elistRt= proxy.displayinprogresstraitmentReclmations();
		
		dataRp=FXCollections.observableArrayList();
		
			for (Repport r :elistR)
				
			{
				
				dataRp.add(new Repport(r.getObject(),r.getText(),r.getState(),r.getUser()));
				//dataw.add(new User (us.getIdUser(),us.getLogin(),us.getFirstName(),us.getLastName(),us.getEmail(),us.getPassword(),us.getCountry(),us.getState(),((Worker) us).getCv()));
					//dataw.add(new Worker(us.getIdUser(),us.getLogin(),us.getFirstName(),us.getLastName(),us.getEmail(),us.getPassword(),us.getCountry(),us.getState(),((Worker) us).getCv(),((Worker) us).getDescription()));
			
			}
			
			tableuntraitedreports.setItems(dataRp);
			 tobject.setCellValueFactory(new PropertyValueFactory<Repport, String>("object"));
			ttest.setCellValueFactory(new PropertyValueFactory<Repport, String>("text"));
			 tstate.setCellValueFactory(new PropertyValueFactory<Repport, String>("state"));
			 treporter.setCellValueFactory(new PropertyValueFactory<Repport, String>("reporterFullName"));
			
			
			//description.setCellValueFactory(new PropertyValueFactory<Repport, String>("reporterFullName"));

			//////traited reportss
			 datatRpt=FXCollections.observableArrayList();
			 for (Repport r :elistRt)
					
				{
					
					datatRpt.add(new Repport(r.getObject(),r.getText(),r.getState(),r.getUser()));
					//dataw.add(new User (us.getIdUser(),us.getLogin(),us.getFirstName(),us.getLastName(),us.getEmail(),us.getPassword(),us.getCountry(),us.getState(),((Worker) us).getCv()));
						//dataw.add(new Worker(us.getIdUser(),us.getLogin(),us.getFirstName(),us.getLastName(),us.getEmail(),us.getPassword(),us.getCountry(),us.getState(),((Worker) us).getCv(),((Worker) us).getDescription()));
				
				}
				
				tablerepports.setItems(datatRpt);
				columnobject.setCellValueFactory(new PropertyValueFactory<Repport, String>("object"));
				columntext.setCellValueFactory(new PropertyValueFactory<Repport, String>("text"));
				 columnstate.setCellValueFactory(new PropertyValueFactory<Repport, String>("state"));
				 columnreporter.setCellValueFactory(new PropertyValueFactory<Repport, String>("reporterFullName"));
			
			
		 } catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	@FXML
    void accept(ActionEvent event) {
		try {
			InitialContext ic2 = new InitialContext();
			AdminserviceEJBRemote proxy2 = (AdminserviceEJBRemote) ic2.lookup("/easyMission-ear/easyMission-ejb/"
					+ "AdminserviceEJB!services.AdminserviceEJBRemote");
			
			
			Repport r= tableuntraitedreports.getItems().get(tableuntraitedreports.getSelectionModel().getSelectedIndex());
			System.out.println("object"+r.getObject());
			System.out.println("state "+r.getState());
			System.out.println("idmiddionreported : "+r.getMission());
			r.setState(1);
			
			proxy2.treatReport(r);
			
		} catch (NamingException e)
		{
			e.printStackTrace();
		}

    }

    @FXML
    void decline(ActionEvent event) {

    }

    @FXML
    void refresh(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("RepportManagement.fxml"));
      	 Scene scene = new Scene(root);
      	 Stage st = (Stage) labeladmin.getScene().getWindow();
      	 st.setScene(scene);
      	 st.close();
   	 st.show();
    }

}
