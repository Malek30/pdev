package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import embadableIDs.RepportId;
import entities.Employer;
import entities.Mission;
import entities.Repport;
import entities.User;
import entities.Worker;

@Remote
public interface AdminserviceEJBRemote {
	public void validatemission(Mission m);
	public void bloqueruser (User u);
	public List<Mission> displayallmissions();
	public Mission findmissionbyId(int idmission);
	public void treatReport (Repport R);
	public List<Repport> displayrepportbydate(Date d);
	public User finduserbyid(int iduser);
	public List<User> displayallusers();
	public User login(String email,String password);
	public void addEmployer(Employer e);
	public void addMission (Mission m,Employer e);
	public void addWorker(Worker w);
	public void repport(User u , Mission m);
	public List<Repport> displaytraitedReclmations();
	public List<Repport> displayuntraitedReclmations();
	public void addReclamation(Repport r);
	public Repport findRepportByiRepportid (RepportId idrepport);

}
