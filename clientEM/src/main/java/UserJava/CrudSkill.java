package UserJava;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import delegate.RecommadationServiceDelegate;
import delegate.UserServiceDelegate;
import entities.Recommendation;
import entities.Skill;
import entities.User;
import entities.Worker;
import frames.frame1Controller;
import javafx.collections.FXCollections;
import security.Driver;
import security.callbackHandler;
import services.UserServicesEJBRemote;

public class CrudSkill {

	public static void main(String[] args) throws NamingException {
		UserServiceDelegate delegate=new UserServiceDelegate();
		RecommadationServiceDelegate delegate1=new RecommadationServiceDelegate();
		Worker u1=null;
		u1=delegate.doFindWorkerById(2);
		List<Skill>ls=u1.getSkills();
		List<Recommendation>lr=delegate1.doFindAllRecommandation();
		for (Skill s : ls){
			System.out.println(s.getName());
		}
		
		
		

	}

}
