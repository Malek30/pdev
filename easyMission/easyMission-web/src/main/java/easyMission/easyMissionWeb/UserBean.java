package easyMission.easyMissionWeb;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Employer;
import entities.Skill;
import entities.User;
import entities.Worker;
import services.UserServicesEJBLocal;

@ManagedBean
@ViewScoped
public class UserBean {
	private User user =new User();
	private List<Skill>SelectedSkills;
	
	@EJB
	private UserServicesEJBLocal userService;
	public String doSave() throws NoSuchAlgorithmException{
		String navTo="";
		if(user.getType()==0){
			Worker w=new Worker();
			w.setLogin(user.getLogin());
			w.setFirstName(user.getLogin());
			w.setLastName(user.getLastName());
			w.setField(user.getField());
			w.setEmail(user.getEmail());
			w.setBirthDate(user.getBirthDate());
			w.setCountry(user.getCountry());
			w.setGender(user.getGender());
			w.setPassword(user.getPassword());
			w.setType(user.getType());
		userService.addWorker(w);
		}
		else{
			Employer w=new Employer();
			w.setLogin(user.getLogin());
			w.setFirstName(user.getLogin());
			w.setLastName(user.getLastName());
			w.setField(user.getField());
			w.setEmail(user.getEmail());
			w.setBirthDate(user.getBirthDate());
			w.setCountry(user.getCountry());
			w.setGender(user.getGender());
			w.setPassword(user.getPassword());
			w.setType(user.getType());
			userService.addEmployer(w);
		}
		navTo="index?faces-redirect=true";
		return navTo;
	}
	public String doComplete() throws NoSuchAlgorithmException{
		String navTo="";
		Worker w=(Worker) AuthentificationBean.user;
		w.setSkills(SelectedSkills);
		userService.updateWorker(w);
		navTo="loggedW?faces-redirect=true";
		return navTo;
	} 
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Skill> getSelectedSkills() {
		return SelectedSkills;
	}
	public void setSelectedSkills(List<Skill> selectedSkills) {
		SelectedSkills = selectedSkills;
	}
	

}
