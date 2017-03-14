package frames;

import javax.ejb.FinderException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Rating;
import entities.Skill;
import entities.User;
import services.MissionServiceEJBRemote;
import services.RatingServiceEJBRemote;

public class Tests {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		InitialContext ctx = new InitialContext();
		InitialContext ctx2 = new InitialContext();
		MissionServiceEJBRemote proxy = (MissionServiceEJBRemote)ctx.lookup("/easyMission-ear/easyMission-ejb/MissionServiceEJB!services.MissionServiceEJBRemote");
		RatingServiceEJBRemote proxy2 = (RatingServiceEJBRemote)ctx2.lookup("/easyMission-ear/easyMission-ejb/RatingServiceEJB!services.RatingServiceEJBRemote");
		//Skill s= new Skill();
		//s.setName("xml");
		//proxy.addSkill(s);
		//System.out.println(proxy.findMission().size()); 
	User u1=proxy2.finduserById(30);
	User u2= proxy2.finduserById(31);
	//proxy2.addUser(u1);
	//proxy2.addUser(u2);
	//Rating r=new Rating();
	//Float x=5f;
	
	proxy2.AddRate( u1, u2, 5);
	
	
	}

}///easyMission-ear/easyMission-ejb/RatingServiceEJB!services.RatingServiceEJBRemote
