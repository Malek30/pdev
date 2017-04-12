package security;

import java.io.IOException;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;




import entities.User;
import services.UserServicesEJBRemote;


public class loginModule implements LoginModule {
	
	public static  String USERNAME="";
	public static  String PASSWORD="";
	private CallbackHandler callbackHandler=null;
	private boolean authentificationSuccessFlag=false;
	public static User u1=null;
	//@EJB UserServicesEJBRemote proxy;

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.callbackHandler=callbackHandler;

	}

	@Override
	public boolean login() throws LoginException {
		InitialContext ctx = null;
		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Object objet = null;
		try {
			objet = ctx.lookup("/easyMission-ear/easyMission-ejb/UserServicesEJB!services.UserServicesEJBRemote");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UserServicesEJBRemote proxy=(UserServicesEJBRemote)objet;
		Callback[] callbackArray=new Callback[2];
		callbackArray[0]=new NameCallback("User Name");
		callbackArray[1]=new PasswordCallback("Password", false);
		try {
			callbackHandler.handle(callbackArray);
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (UnsupportedCallbackException e) {
			e.printStackTrace();
		}
		String name=((NameCallback)callbackArray[0]).getName();
		String password=new String(((PasswordCallback)callbackArray[1]).getPassword());
		u1=proxy.findUserByLogin(name);
		
		if(u1!=null){
			USERNAME=u1.getLogin();
			PASSWORD=u1.getPassword();
		
		if(USERNAME.equals(name)&&PASSWORD.equals(password)){
			System.out.println("authentification success ...");
			
			authentificationSuccessFlag=true;
			
		}else{
			authentificationSuccessFlag=false;
			throw new FailedLoginException("authentification Failure....");
		}
		
		}
		return authentificationSuccessFlag;
//		if(USERNAME.equals(name)&&PASSWORD.equals(password)){
//			System.out.println("authentification success ...");	
//			authentificationSuccessFlag=true;
//		}else{
//			authentificationSuccessFlag=false;
//			throw new FailedLoginException("authentification Failure....");
//		}
//		
//		
//		return authentificationSuccessFlag;
//		
	}

	@Override
	public boolean commit() throws LoginException {
		// TODO Auto-generated method stub
		return authentificationSuccessFlag;
	}

	@Override
	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

}
