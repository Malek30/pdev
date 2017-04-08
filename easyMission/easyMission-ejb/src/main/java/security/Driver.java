package security;

import javax.ejb.EJB;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import entities.User;
import services.UserServicesEJBLocal;

public class Driver {
	@EJB
	private static UserServicesEJBLocal userServiceLocal;
	public static void main(String[] args) {
//		System.setProperty("java.security.auth.login.config", "jaas.config");
//		LoginContext loginContext=null;
//		try {
//			 loginContext=new LoginContext("EM",new callbackHandler());
//		} catch (LoginException e) {
//
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		while(true){
//			try {
//				loginContext.login();
//				System.exit(0);
//			} catch (LoginException e) {
//				System.out.println(e.getMessage());
//			}
//		}
		User u=userServiceLocal.findUserByLogin("malek1");
		System.out.println("test : "+u.getFirstName());
	}

}
