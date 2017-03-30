package frames;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import delegate.RecommadationServiceDelegate;
import delegate.UserServiceDelegate;
import entities.Employer;
import entities.Recommendation;
import entities.Skill;
import entities.Worker;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.UserRecommandationServiceEJBRemote;
import services.UserServicesEJBRemote;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class EditWorkerController implements Initializable{
	UserServiceDelegate delegate= new UserServiceDelegate();
	RecommadationServiceDelegate delegate1=new RecommadationServiceDelegate();
	private  static ObservableList<Skill>data;
	private  static ObservableList<Recommendation>data1;
	@FXML
    private AnchorPane ap;

    @FXML
    private ImageView iv;

    @FXML
    private JFXHamburger ham;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private ImageView ppic;

    @FXML
    private JFXTextField firstname;

    @FXML
    private JFXTextField lastname;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField cnumber;

    @FXML
    private JFXComboBox field;

    @FXML
    private JFXDatePicker bdate;

    @FXML
    private Button btpic;

    @FXML
    private Button update;



    @FXML
    private TableView<Skill> tabskill;

    @FXML
    private TableColumn<Skill,String> skil;

    @FXML
    private JFXTextArea desc;

    @FXML
    private TableView<Recommendation>rcd;

    @FXML
    private JFXComboBox<Skill> sk;

    @FXML
    private Button adsk;

    @FXML
    private TableColumn<Recommendation, String> txt;
    @FXML
    private Button delrcd;
    @FXML
    private Button delsk;

    @FXML
    private TableColumn<Recommendation, String> user;
    public static Image image,image1;
    File picture,picture1;
    public static ArrayList<Skill>skill=new ArrayList<>();
    private  static ObservableList<Skill>data2;
    public static List<Skill>lskl=new ArrayList<>();
    public static List<Skill>userSkill;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		field.getItems().addAll(
	            "Mecanique",
	            "Informatique",
	            "Design",
	            "ART",
	            "Other");
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
		//-------------- server cnx------------
		/*InitialContext ctx = null;
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
		UserServicesEJBRemote proxy=(UserServicesEJBRemote)objet;*/
		//-------affichage-------
		//Worker emp=proxy.findWorkerById(frame1Controller.id);
		Worker emp=delegate.doFindWorkerById(frame1Controller.id);
		firstname.setPromptText(emp.getFirstName());
		lastname.setPromptText(emp.getLastName());
		email.setPromptText(emp.getEmail());
		bdate.setPromptText(emp.getBirthDate());
		cnumber.setPromptText(emp.getPhoneNumber());
		desc.setPromptText(emp.getDescription());
		field.setPromptText(emp.getField());
		
		
		//----------------list skills
		int userid=emp.getIdUser();
		
		//List<Skill> sklist=proxy.findAllSkills();
		List<Skill> sklist=delegate.dofindAllSkills();
		//List<Worker>lw=proxy.findAllWorkers();
		List<Worker>lw=delegate.doFindAllWorker();
		userSkill=emp.getSkills();
		
		List<Worker>lworkers=null;
		data=FXCollections.observableArrayList();
		for(Skill s : sklist){
			lworkers=s.getWorkers();
			for(Worker w : lworkers){
				if(w.getIdUser()==userid){
					lskl.add(s);}}}
		
		for( Skill s : userSkill){
			System.out.println(s.getName());
			data.add(new Skill(s.getName()));
		}
		tabskill.setItems(data);
		skil.setCellValueFactory(new PropertyValueFactory<Skill,String>("name"));
		
		
		ArrayList<Skill>skill=(ArrayList<Skill>)delegate.dofindAllSkills();
		ArrayList<Skill>skk=new ArrayList<>();
		
		ArrayList<Skill>nsk=new ArrayList<>();
		for(Skill s: skill){
			skk.add(s);
			for( Skill s1 : userSkill){
				if(s.getName().equals(s1.getName())){
					skk.remove(s);
				}
			}
			
		}
		
		
			
		
		data2 =FXCollections.observableArrayList(skk);
		sk.getItems().addAll(data2);
		//-------------------------- list recommandation-----------
		/*InitialContext ctx2 = null;
		try {
			ctx2 = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object objet2 = null;
		try {
			objet2 = ctx2.lookup("/easyMission-ear/easyMission-ejb/UserRecommandationServiceEJB!services.UserRecommandationServiceEJBRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserRecommandationServiceEJBRemote proxy2=(UserRecommandationServiceEJBRemote)objet2;*/
		
		List<Recommendation>lrr=new ArrayList<>();
		//List<Recommendation>lr=proxy2.findAllRecommandation();
		List<Recommendation>lr=delegate1.doFindAllRecommandation();
		for(Recommendation r : lr){
			if(r.getRecommended().getIdUser()==1){
				//System.out.println("test");
				lrr.add(r);
			}}
		data1=FXCollections.observableArrayList();
		
		
		for(Recommendation r: lrr){
			System.out.println(r.getText()+" "+r.getRecommender().getFirstName());
			data1.add(new Recommendation(r.getText(),r.getRecommender()));
			
		}
		rcd.setItems(data1);
		txt.setCellValueFactory(new PropertyValueFactory<Recommendation,String>("text"));
		user.setCellValueFactory(new PropertyValueFactory<Recommendation,String>("RecommanderName"));
		
		picture=new File(emp.getPicture());
	       
        BufferedImage bufferedImage = null;
      
		try {
			bufferedImage = ImageIO.read(picture);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 image = SwingFXUtils.toFXImage(bufferedImage, null);
		
			ppic.setImage(image);
			
			
	}
    @FXML
    void exit(ActionEvent event) {
    	Stage stage = (Stage) ap.getScene().getWindow();
	    stage.close();
    }
    @FXML
    void update(ActionEvent event) throws IOException, NamingException {
    	//-------------- server cnx------------
    			/*InitialContext ctx = null;
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
    			UserServicesEJBRemote proxy=(UserServicesEJBRemote)objet;*/
    			//-------update-------
    			//Worker emp=proxy.findWorkerById(frame1Controller.id);
    			Worker emp=delegate.doFindWorkerById(frame1Controller.id);
    			if(firstname.getText().equals("")){
    				String fn=emp.getFirstName();
    				emp.setFirstName(fn);
    			}else{
    				emp.setFirstName(firstname.getText());	
    			}
    			
    			if(lastname.getText().equals("")){
    				String ln=emp.getLastName();
    				emp.setLastName(ln);
    			}else{
    				emp.setLastName(lastname.getText());
    			}
    			
    			if(email.getText().equals("")){
    				String em=emp.getEmail();
    				emp.setEmail(em);
    			}else{
    				emp.setEmail(email.getText());
    			}
    			
    			if(field.getValue()==null){
    				String f=emp.getField();
    				emp.setField(f);
    			}else{
    				emp.setField(field.getValue().toString());
    			}
    			
    			if(bdate.getValue()==null){
    				String BD=emp.getBirthDate();
    				emp.setBirthDate(BD);
    			}else{
    				emp.setBirthDate(bdate.getValue().toString());
    			}
    	    	
    	    	
    	    	if(cnumber.getText().equals("")){
    				String ad=emp.getPhoneNumber();
    				emp.setPhoneNumber(ad);
    			}else{
    				emp.setPhoneNumber(cnumber.getText());
    			}
    	    	if(desc.getText().equals("")){
    				String ad=emp.getDescription();
    				emp.setDescription(ad);
    			}else{
    				emp.setDescription(desc.getText());
    			}
    	    	if(picture1==null){
    				String ad=emp.getPicture();
    				emp.setPicture(ad);
    			}else{
    				emp.setPicture(picture1.toString());
    			}
    	    	
    	    	emp.setSkills(lskl);
    	    	//proxy.updateWorker(emp);
    	    	delegate.doUpdateWorker(emp);
    	    	Stage stage = (Stage) desc.getScene().getWindow();
    		    stage.close();
    		    Parent root = FXMLLoader.load(getClass().getResource("User2.fxml"));
    	        Scene scene1 = new Scene(root);
    	        stage.setScene(scene1);
    	        stage.show();
    	    	
    	    	
    	    	

    }
    @FXML
    void changePic(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
		picture1 = fileChooser.showOpenDialog(null);
		if (picture1 == null) {
			return;
		}
		try {
			BufferedImage bufferedImage = ImageIO.read(picture1);
		 image1 = SwingFXUtils.toFXImage(bufferedImage, null);
			ppic.setImage(image1);
                        
                        
		} catch (IOException ex) {
		}
                System.out.println(picture1);

    }
    @FXML
    void adskill(ActionEvent event) {
    	data=FXCollections.observableArrayList();
    	lskl.add(sk.getValue());
    	/*for(Skill s : userSkill){
			if(sk.getValue().toString().equals(s.toString())){
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Warning ");
				alert.setHeaderText(null);
				alert.setContentText(" Skill already added");

				alert.showAndWait();
				
			}else{
			//	lskl.add(sk.getValue());
			}*/
				
		//}
    	
    	for( Skill s : lskl){
			System.out.println(s.getName());
			data.add(new Skill(s.getName()));
		}
		tabskill.setItems(data);
		skil.setCellValueFactory(new PropertyValueFactory<Skill,String>("name"));

    }
    @FXML
    void delrcd(ActionEvent event) throws NamingException, IOException {
    	/*InitialContext ctx1=new InitialContext();
		InitialContext ctx2=new InitialContext();
		Object objet2=ctx2.lookup("/easyMission-ear/easyMission-ejb/UserRecommandationServiceEJB!services.UserRecommandationServiceEJBRemote");
		Object objet1=ctx1.lookup("/easyMission-ear/easyMission-ejb/UserServicesEJB!services.UserServicesEJBRemote");
		UserRecommandationServiceEJBRemote proxy=(UserRecommandationServiceEJBRemote)objet2;
		UserServicesEJBRemote proxy1=(UserServicesEJBRemote)objet1;*/
		
    	Recommendation m = rcd.getSelectionModel().getSelectedItem();
    	System.out.println("id :"+m.getRecommender().getFirstName());
    	
    	//System.out.println(m.getIdRecommendation());
    	//Recommendation r=proxy.FindRecommandationBTextAndRecommander(m.getText());
    	Recommendation r=delegate1.doFindRecommandationByText(m.getText(),m.getRecommender());
    	System.out.println(r.getRecommanderName());
    	System.out.println(r.getIdRecommendation().getIdRecommendedPK());
    	r.setState(0);
    	//proxy.changeState(r);
    	delegate1.dochangeState(r);
    	
    	Stage stage = (Stage) desc.getScene().getWindow();
	    stage.close();
	    Parent root = FXMLLoader.load(getClass().getResource("User2.fxml"));
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
    	

    }
    @FXML
    void delskill(ActionEvent event) throws NamingException, IOException {
    	/*InitialContext ctx1=new InitialContext();
    	Object objet1=ctx1.lookup("/easyMission-ear/easyMission-ejb/UserServicesEJB!services.UserServicesEJBRemote");
    	UserServicesEJBRemote proxy1=(UserServicesEJBRemote)objet1;*/
    	//Worker emp=proxy1.findWorkerById(frame1Controller.id);
    	Worker emp=delegate.doFindWorkerById(frame1Controller.id);
    	List<Skill>ls=emp.getSkills();
    	Skill s11=tabskill.getSelectionModel().getSelectedItem();
    	//Skill s=proxy1.findSkillByName(s11.getName());
    	Skill s=delegate.doFindSkillByName(s11.getName());
    	List<Skill>l=new ArrayList<>();
    	for(Skill s1 : ls){
    		l.add(s1);
    		if(s1.getName().equals(s.getName())){
    			l.remove(s1);
    		}
    	}
    	emp.setSkills(l);
    	//proxy1.updateWorker(emp);
    	delegate.doUpdateWorker(emp);
    	Stage stage = (Stage) desc.getScene().getWindow();
	    stage.close();
	    Parent root = FXMLLoader.load(getClass().getResource("User2.fxml"));
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
    	
    	
    }

}
