package frames;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import entities.Recommendation;
import entities.Skill;
import entities.Worker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.UserServicesEJBRemote;

public class RecommandationController implements Initializable{
	@FXML
    private AnchorPane ap;

    @FXML
    private ImageView iv;

    @FXML
    private JFXHamburger ham;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private Text fn;

    @FXML
    private Text ln;

    @FXML
    private Text mail;

    @FXML
    private Text country;

    @FXML
    private Text field;

    @FXML
    private ImageView ppic;

    @FXML
    private Text bdate;

    @FXML
    private Text bank;

    @FXML
    private TableView<Skill> tabskill;

    @FXML
    private TableColumn<Skill,String> skil;

    @FXML
    private Text number;

    @FXML
    private TextArea desc;

    @FXML
    private TableView<Recommendation> rcd;

    @FXML
    private TableColumn<Recommendation,String> txt;

    @FXML
    private TableColumn<Recommendation,String> user;

    @FXML
    private Text number1;

    @FXML
    private ComboBox<Worker> sk;

    @FXML
    private Button show;

    @FXML
    private Button add;
    private  static ObservableList<Worker>data2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			VBox box =FXMLLoader.load(getClass().getResource("DrawerContent2.fxml"));
			drawer.setSidePane(box);
			
		
    	
    	HamburgerBackArrowBasicTransition burgertask = new HamburgerBackArrowBasicTransition(ham);
    	burgertask.setRate(-1);
    	ham.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) ->{
    		burgertask.setRate(burgertask.getRate() * -1);
    		burgertask.play();
    		if(drawer.isShown())
            {
                drawer.close();
            }else
                drawer.open();
    		
    		
    	
    	}
    	);
    }catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		InitialContext ctx = null;
		try {
			ctx = new InitialContext();
		} catch (NamingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Object objet = null;
		try {
			objet = ctx.lookup("/easyMission-ear/easyMission-ejb/UserServicesEJB!services.UserServicesEJBRemote");
		} catch (NamingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		UserServicesEJBRemote proxy=(UserServicesEJBRemote)objet;
		ArrayList<Worker>workers=(ArrayList<Worker>)proxy.findAllWorkers();
		
		data2 =FXCollections.observableArrayList(workers);
		sk.getItems().addAll(data2);
		
	}
	 @FXML
	    void add(ActionEvent event) {

	    }

	    @FXML
	    void exit(ActionEvent event) {
	    	Stage stage = (Stage) ap.getScene().getWindow();
		    stage.close();
	    }

	    @FXML
	    void show(ActionEvent event) {
	    	
	    }


}
