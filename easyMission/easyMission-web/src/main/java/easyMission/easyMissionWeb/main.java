package easyMission.easyMissionWeb;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import entities.Skill;
import entities.Worker;
import services.UserServicesEJBLocal;

public class main {
	@EJB
	static
	UserServicesEJBLocal userServicesEJBLocal;

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		List<Skill>test=new ArrayList<>();
		Skill s=userServicesEJBLocal.findSkillByName("c");
		test.add(s);
		Worker worker=userServicesEJBLocal.findWorkerById(1);
		worker.setFirstName("malek11");
		
		worker.setSkills(test);
		System.out.println("test malek");
		userServicesEJBLocal.updateWorker(worker);
	}

}
