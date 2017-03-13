package frames;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import services.AdminserviceEJBRemote;

public class Chart1Controller implements Initializable {
	@FXML
	private PieChart PieChartUsers;
	private BorderPane root;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
InitialContext ic;
try {
	ic = new InitialContext();
	AdminserviceEJBRemote proxy = (AdminserviceEJBRemote) ic.lookup("/easyMission-ear/easyMission-ejb"
			+ "/AdminserviceEJB!services.AdminserviceEJBRemote");
	long x =proxy.nbrworkers();
	long y =proxy.nbremployers();
	ObservableList<PieChart.Data> piechartuser = FXCollections.observableArrayList(
			new PieChart.Data("employer",y ),
			new PieChart.Data("worker",x )
				
			);
	PieChartUsers.setData(piechartuser);
	PieChartUsers.setLegendSide(Side.BOTTOM);
	PieChartUsers.setLabelsVisible(true);
	
	root = new BorderPane();
} catch (NamingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
		
	}

}
