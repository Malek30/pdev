package delegate;

import java.util.List;

import javax.naming.NamingException;
import javax.security.auth.login.LoginException;

import entities.Recommendation;
import entities.User;
import security.loginRemote;
import serviceLocator.ServiceLocator;
import services.UserRecommandationServiceEJBRemote;

public class loginServiceDelegate {
private static final String JNDI = "/easyMission-ear/easyMission-ejb/login!security.loginRemote";
	
	private static loginRemote getProxy(){
		return (loginRemote) ServiceLocator.getInstance().getProxy(JNDI);
	}
	public static void doLogin()throws NamingException, LoginException {
		getProxy().login();
		
	}
	
}
