package delegate;

import serviceLocator.ServiceLocator;
import javax.naming.NamingException;

import entities.User;
import security.SecurityServiceEJBRemote;
import serviceLocator.ServiceLocator;

public class SecurityServiceDelegate {





	private static final String JNDI = "/easyMission-ear/easyMission-ejb/SecurityServiceEJB!security.SecurityServiceEJBRemote";
	private static SecurityServiceEJBRemote getProxy(){
		return (SecurityServiceEJBRemote) ServiceLocator.getInstance().getProxy(JNDI);
	}
	
	public static User doGetCnx(String login,String pwd){
		return getProxy().getConnection(login, pwd);
	}
	public static boolean UserExist(String login){
		return getProxy().UserExist(login);}
	

}
