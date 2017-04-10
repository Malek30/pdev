package UserJava;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import delegate.RecommadationServiceDelegate;
import delegate.SecurityServiceDelegate;
import delegate.UserServiceDelegate;
import entities.Recommendation;
import entities.Skill;
import entities.User;
import entities.Worker;
import frames.frame1Controller;
import frames.main;
import javafx.collections.FXCollections;
import security.Driver;
import security.callbackHandler;
import services.UserServicesEJBRemote;

public class CrudSkill {

	public static void main(String[] args) throws NamingException, NoSuchAlgorithmException {
		UserServiceDelegate delegate=new UserServiceDelegate();
		RecommadationServiceDelegate delegate1=new RecommadationServiceDelegate();
		SecurityServiceDelegate delegate2=new SecurityServiceDelegate();
		
//		System.out.println("test");
//		User x=delegate2.doGetCnx("malek1", "123");
//		System.out.println("test : "+x.getFirstName());
		//String x=delegate.doCryte("123");
//		User u=delegate.doFindUserByLoginAndPassword("malek1","123");
//		System.out.println(u.getFirstName());
		main.main(null);
}}
