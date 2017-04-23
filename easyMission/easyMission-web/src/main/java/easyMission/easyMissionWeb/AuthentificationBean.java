package easyMission.easyMissionWeb;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import entities.Employer;
import entities.Skill;
import entities.User;
import entities.Worker;
import services.UserServicesEJBLocal;



@ManagedBean
@ApplicationScoped
public class AuthentificationBean {

	@EJB
	private UserServicesEJBLocal userServiceLocal;
	public static User user =new User();
	private Worker worker= new Worker();
	private Employer employer=new Employer();
	private List<Skill>skills;
	private String [] SelectedSkills;
	
	 @PostConstruct
	    public void init() {
	        skills=userServiceLocal.findAllSkills();
	    }
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	private boolean loggedIn=false;
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String doLogin() throws NoSuchAlgorithmException{
		String navTo="";
		User found =userServiceLocal.findUserBYLoginAndPassword(user.getLogin(), user.getPassword());
		if(found!=null){
			if(found instanceof Employer){
				employer=(Employer) found;
				loggedIn=true;
				if(employer.getAdress()!=null){
					navTo="loggedE?faces-redirect=true";
				}else{
					
					navTo="emloyerInfo?faces-redirect=true";
				}
			}else{
				worker=userServiceLocal.findWorkerById(found.getIdUser());
				loggedIn=true;
				if(worker.getDescription()!=null){
					
				navTo="loggedW?faces-redirect=true";
			}else{
				navTo="workerInfo?faces-redirect=true";
			}
			}
			
		}
		return navTo;
	}
	 
	    public List<Skill> userskill() {
	    	List<Skill>l=new ArrayList<>();
	    	if(worker.getSkills()!=null){
	    		List<Skill>sk=worker.getSkills();
	    		List<Skill>lsk=new ArrayList<Skill>();
	    		for(Skill s: skills){
	    			lsk.add(s);
	    			for(Skill s1: sk){
	    				if(s.getName().equals(s1.getName())){
	    					lsk.remove(s);
	    				}
	    			}
	    		}
	    		l=lsk;
	    	}else{
	    		l = userServiceLocal.findAllSkills();
	    	}
	       
	        return l;
	    }
	    public String doComplete() throws NoSuchAlgorithmException {
			String navTo="";
			System.out.println(SelectedSkills.toString());
			List<Skill>test=new ArrayList<Skill>(); 
			List<String> wordList = Arrays.asList(SelectedSkills); 
			for( String s : wordList){
				Skill x=userServiceLocal.findSkillByName(s);
				test.add(x);
				
			}
			
			worker.setSkills(test);
			System.out.println("test malek");
			userServiceLocal.updateWorker(worker);
			navTo="loggedW?faces-redirect=true";
			return navTo;
		} 
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public String[] getSelectedSkills() {
		return SelectedSkills;
	}
	public void setSelectedSkills(String[] selectedSkills) {
		SelectedSkills = selectedSkills;
	}
	
	
	
}
