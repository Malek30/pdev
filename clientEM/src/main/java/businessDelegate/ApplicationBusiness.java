package businessDelegate;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Application;
import entities.Mission;
import entities.Skill;
import entities.Worker;
import services.ApplicationEJB;
import services.ApplicationEJBRemote;

public class ApplicationBusiness {

	private static String path = "/easyMission-ear/easyMission-ejb/ApplicationEJB!services.ApplicationEJBRemote";
	private static List<Mission> allMissions;
	private static List<Skill> allSkills;
	private Worker worker;

	public ApplicationBusiness(int id) {
		InitialContext ctx;
		try {
			loadUser(id);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public List<Mission> getAllMissions() throws NamingException {
		if (allMissions == null || true) {
			allMissions = new ArrayList<>();
			InitialContext ctx = new InitialContext();
			Object obj = ctx.lookup(path);
			ApplicationEJBRemote proxy = (ApplicationEJBRemote) obj;
			allMissions = proxy.findAll(worker.getIdUser());
		}
		return allMissions;

	}

	public List<Skill> getAllSkills() throws NamingException {
		if (allSkills == null || true) {
			allSkills = new ArrayList<>();
			InitialContext ctx = new InitialContext();
			Object obj = ctx.lookup(path);
			ApplicationEJBRemote proxy = (ApplicationEJBRemote) obj;
			allSkills = proxy.findallSkills();
		}
		return allSkills;
	}

	public List<Mission> FilterMissions(String title, List<Skill> ls, String type, int min, int max)
			throws NamingException {
		List<Mission> lm = new ArrayList<>();
		InitialContext ctx = new InitialContext();
		Object obj = ctx.lookup(path);
		ApplicationEJBRemote proxy = (ApplicationEJBRemote) obj;
		allMissions = proxy.filter(worker.getIdUser(), title, ls, type, min, max);

		return allMissions;
	}

	public boolean apply(Worker w, Mission m, String text) throws NamingException {
		InitialContext ctx = new InitialContext();
		Object obj = ctx.lookup(path);
		ApplicationEJBRemote proxy = (ApplicationEJBRemote) obj;
		proxy.apply(worker, m, text);
		loadUser(worker.getIdUser());
		for (Application app : worker.getApplications()) {
			if (app.getWorker().getIdUser() == worker.getIdUser())
				return true;
		}
		return false;
	}

	public void loadUser(int id) throws NamingException {
		InitialContext ctx = new InitialContext();
		ctx = new InitialContext();
		Object obj = ctx.lookup(path);
		ApplicationEJBRemote proxy = (ApplicationEJBRemote) obj;
		worker = (Worker) proxy.findUser(id);
	}
}
