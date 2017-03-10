package frames;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Mission;
import services.AdminserviceEJBRemote;

public class testinginconsole {

	public testinginconsole() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NamingException {
		InitialContext	ic = new InitialContext();
		
		AdminserviceEJBRemote proxy = (AdminserviceEJBRemote) ic.lookup("/easyMission-ear/easyMission-ejb"
				+ "/AdminserviceEJB!services.AdminserviceEJBRemote");
	
	List<Mission>  elist = proxy.displayallmissions();
	for (Mission m : elist)
	{
		System.out.println(m.getDescription());
	}

	}

}
