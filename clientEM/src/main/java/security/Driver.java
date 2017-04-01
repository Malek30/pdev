package security;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class Driver {
	public static void main(String[] args) {
		System.setProperty("java.security.auth.login.config", "jaastutorial.config");
		LoginContext loginContext=null;
		try {
			 loginContext=new LoginContext("ZaJaasTutorial",new callbackHandler());
		} catch (LoginException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			System.exit(0);
		}
		while(true){
			try {
				loginContext.login();
				System.exit(0);
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

}
