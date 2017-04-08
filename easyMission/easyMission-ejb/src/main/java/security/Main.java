package security;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import entities.User;
import services.UserServicesEJBLocal;

public class Main {
	@EJB
	private static SecurityServiceEJBLocal us;
	
	public static void main(String[] args) {

		System.setProperty("java.security.auth.login.config", "jaas.config");
		loginModule l=new loginModule();
//		
		callbackHandler x=new callbackHandler();
		LoginContext loginContext=null;
		x.setLogin("malek1");
		x.setPwd("123");
		boolean flag=false;

		 try {
			loginContext=new LoginContext("EM",x);
			loginContext.login();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
