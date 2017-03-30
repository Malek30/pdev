package frames;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javafx.scene.control.Label;
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
	public static Skill s11=null;
	public static Recommendation m=null;
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
    private Label fnamelabel;

    @FXML
    private Label lnamelabel;

    @FXML
    private Label emailabel;

    @FXML
    private Label fieldlabel;

    @FXML
    private Label datelabel;

    @FXML
    private Label numberlabel;

    @FXML
    private Label updatelabel;

    @FXML
    private Label dsklabel;

    @FXML
    private Label rcdlabel;

    @FXML
    private Label asklabel;

    @FXML
    private TableColumn<Recommendation, String> user;
    public static Image image,image1;
    public static Worker emp;
    File picture,picture1;
    public static ArrayList<Skill>skk=new ArrayList<>();
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
		emp=delegate.doFindWorkerById(frame1Controller.id);
		firstname.setPromptText(emp.getFirstName());
		lastname.setPromptText(emp.getLastName());
		email.setPromptText(emp.getEmail());
		bdate.setPromptText(emp.getBirthDate());
		cnumber.setPromptText(emp.getPhoneNumber());
		desc.setPromptText(emp.getDescription());
		field.setPromptText(emp.getField());
		
		
		//----------------list skills-----------
		int userid=emp.getIdUser();

		List<Skill> sklist=delegate.dofindAllSkills();
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
		List<Recommendation>lrr=new ArrayList<>();
		List<Recommendation>lr=delegate1.doFindAllRecommandation();
		for(Recommendation r : lr){
			if(r.getRecommended().getIdUser()==1){
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
    	if(sk.getPromptText().equals("Skills list")){
    		asklabel.setText("please make sure you select a skill");
    	}else{
    	data=FXCollections.observableArrayList();
    	lskl.add(sk.getValue());
    	for( Skill s : lskl){
			System.out.println(s.getName());
			data.add(new Skill(s.getName()));
		}
		tabskill.setItems(data);
		skil.setCellValueFactory(new PropertyValueFactory<Skill,String>("name"));
		data2.clear();
		sk.getItems().clear();
		skk.removeAll(lskl);
		data2 =FXCollections.observableArrayList(skk);
		sk.getItems().addAll(data2);}
    }
    @FXML
    void delrcd(ActionEvent event) throws NamingException, IOException {
    	 m = rcd.getSelectionModel().getSelectedItem();
    	System.out.println("id :"+m.getRecommender().getFirstName());
    	Recommendation r=delegate1.doFindRecommandationByText(m.getText(),m.getRecommender());
    	System.out.println(r.getRecommanderName());
    	System.out.println(r.getIdRecommendation().getIdRecommendedPK());
    	r.setState(0);
    	
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
    	
    	Worker emp=delegate.doFindWorkerById(frame1Controller.id);
    	List<Skill>ls=emp.getSkills();
    	 s11=tabskill.getSelectionModel().getSelectedItem();
    	Skill s=delegate.doFindSkillByName(s11.getName());
    	List<Skill>l=new ArrayList<>();
    	for(Skill s1 : ls){
    		l.add(s1);
    		if(s1.getName().equals(s.getName())){
    			l.remove(s1);
    		}
    	}
    	emp.setSkills(l);
    	delegate.doUpdateWorker(emp);
    	Stage stage = (Stage) desc.getScene().getWindow();
	    stage.close();
	    Parent root = FXMLLoader.load(getClass().getResource("User2.fxml"));
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
    	 }
    @FXML
    void Lskillaction(MouseEvent event) {
    	asklabel.setText("");
    }
    @FXML
    void skillcomboaction(MouseEvent event) {
    	sk.setPromptText(sk.getValue().toString());
    	//System.out.println("done");

    }

    @FXML
    void skillaction(MouseEvent event) {
    	if(sk.getPromptText().equals("Skills list")){
    		asklabel.setText("please make sure you select a skill");
    	}
    }
    @FXML
    void Lupdateaction(MouseEvent event) {

    }

    @FXML
    void dateaction(MouseEvent event) {
    	if(bdate.getPromptText().equals(emp.getBirthDate())){
    		datelabel.setText("");
    	}else{
    		bdate.setPromptText(bdate.getValue().toString());
    	}
    }
    @FXML
    void dateaction1(MouseEvent event) {
    	datelabel.setText("make sure before you chage your birthdate");
    }
    @FXML
    void tabskillaction(MouseEvent event) {
    	s11=tabskill.getSelectionModel().getSelectedItem();
    	System.out.println("done");
    }
    @FXML
    void dskillaction(MouseEvent event) {
    	if(s11==null){
    	dsklabel.setText("make sure you select a skill");}
    	else{
    		dsklabel.setText("make sure before you delete the skill");
    	}
    }
    @FXML
    void Ldskillaction(MouseEvent event) {
    	dsklabel.setText("");
    }

    @FXML
    void emailaction1(MouseEvent event) {
    	emailabel.setText("make sure before you change the email");
    	

    }
    @FXML
    void emailaction(MouseEvent event) {
    	if(email.getText().equals("")){
    		emailabel.setText("");
    	}else{
    	if(isEmail(email.getText())==false){
    		emailabel.setText("email is invalid");
    	}else{
    		emailabel.setText("");
    		email.setPromptText(email.getText());
    	}}
    }

    @FXML
    void fieldaction(MouseEvent event) {
    	if(field.getPromptText().equals(emp.getField())){
    	fieldlabel.setText("");}

    }
    @FXML
    void fieldaction1(MouseEvent event) {
    	fieldlabel.setText("make sure before you change your field");
    }

    @FXML
    void fnameaction(MouseEvent event) {
    	if(firstname.getText().equals("")){
    		fnamelabel.setText("");
    	}else{
    		if(isAlpha(firstname.getText())==false){
    			fnamelabel.setText("make sure you write text");
    		}else{
    			fnamelabel.setText("");
    			firstname.setPromptText(firstname.getText());
    		}}
    	

    }
    @FXML
    void fnameaction1(MouseEvent event) {
    	fnamelabel.setText("make sure before you change your first name");
    }

    @FXML
    void lnameaction(MouseEvent event) {
    	if(lastname.getText().equals("")){
    		lnamelabel.setText("");
    	}else{
    		if(isAlpha(firstname.getText())==false){
    			lnamelabel.setText("make sure you write text");
    		}else{
    			lnamelabel.setText("");
    			lastname.setPromptText(lastname.getText());
    		}}
    	
    }
    @FXML
    void lnameaction1(MouseEvent event) {
    	lnamelabel.setText("make sure before you change your last name");
    }

    @FXML
    void numberaction(MouseEvent event) {
    	if(cnumber.getText().equals("")){
    		numberlabel.setText("");
    	}else{
    		
    		if(isNum(cnumber.getText())==false){
    			numberlabel.setText("make sure you write numeric");
    		}else{
    			numberlabel.setText("");
    			cnumber.setPromptText(cnumber.getText());
    		}
    	}
    }
    @FXML
    void numberaction1(MouseEvent event) {
    	numberlabel.setText("make sure before you change your phone number");

    }

    @FXML
    void rcdaction(MouseEvent event) {
if(m==null){
	rcdlabel.setText("make sure you select a recommandation");
}else{
	rcdlabel.setText("are you sure you want to delete it");
}
    }
    @FXML
    void rcdactionexit(MouseEvent event) {
    	rcdlabel.setText("");
    }
    @FXML
    void tabrcdaction(MouseEvent event) {
    	m = rcd.getSelectionModel().getSelectedItem();
    	System.out.println("done");

    }


    @FXML
    void updateaction(MouseEvent event) {

    }
    public static boolean isNum(String strNum) {
	    boolean ret = true;
	    try {

	        Double.parseDouble(strNum);

	    }catch (NumberFormatException e) {
	        ret = false;
	    }
	    return ret;
	}
    public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\\\\\+]+(\\.[\\w\\\\]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
    



    

 
}
