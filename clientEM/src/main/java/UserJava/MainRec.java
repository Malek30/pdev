package UserJava;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Recommendation;
import entities.Skill;
import entities.User;
import entities.Worker;
import services.UserRecommandationServiceEJBRemote;
import services.UserServicesEJBRemote;



public class MainRec {
public static void main(String[] args) throws NamingException {

	
	
		
		InitialContext ctx=new InitialContext();
		Object objet=ctx.lookup("/easyMission-ear/easyMission-ejb/UserRecommandationServiceEJB!services.UserRecommandationServiceEJBRemote");
		UserRecommandationServiceEJBRemote proxy=(UserRecommandationServiceEJBRemote)objet;
		InitialContext ctx1=new InitialContext();
		Object objet1=ctx1.lookup("/easyMission-ear/easyMission-ejb/UserServicesEJB!services.UserServicesEJBRemote");
		UserServicesEJBRemote proxy1=(UserServicesEJBRemote)objet1;
		User u1=proxy1.findUserById(7);
		User u2=proxy1.findUserById(8);
		proxy.addUserRecommandation(u1, u2, "nas tayba");
		
		//proxy.addUserRecommandation(7,8,"nas tayba");
		
		System.out.println("done");

		
		
		
	}
}
