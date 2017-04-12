package UserJava;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
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
import security.loginRemote;
import services.UserServicesEJBRemote;

public class CrudSkill {

	public static void main(String[] args) throws NamingException, NoSuchAlgorithmException {
		UserServiceDelegate delegate=new UserServiceDelegate();
		RecommadationServiceDelegate delegate1=new RecommadationServiceDelegate();
		SecurityServiceDelegate delegate2=new SecurityServiceDelegate();
//		InitialContext ctx=new InitialContext();
//		Object objet=ctx.lookup("/easyMission-ear/easyMission-ejb/login!security.loginRemote");
//		loginRemote proxy=(loginRemote)objet;
//		System.out.println("test");
		User x=delegate2.doGetCnx("malek1", "123");
//		System.out.println("test : "+x.getFirstName());
		
//		User u=delegate.doFindUserByLoginAndPassword("malek1","123");
//		System.out.println(u.getFirstName());
		
		
}}
