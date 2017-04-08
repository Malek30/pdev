package security;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.ejb.EJB;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import org.omg.CORBA.PRIVATE_MEMBER;


import entities.User;
import services.UserServicesEJBLocal;


public class loginModule implements LoginModule {
	
	@EJB
	private UserServicesEJBLocal userServiceLocal;
	public User u=null;
	private  String USERNAME="malek1";
	private  String PASSWORD="123";
	private CallbackHandler callbackHandler=null;
	private boolean authentificationSuccessFlag=false;
	public static User u1=null;

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.callbackHandler=callbackHandler;

	}

	@Override
	public boolean login() throws LoginException {
		
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
		
		//u=userServiceLocal.findUserByLogin("malek1");
//		if(u1!=null){
//			USERNAME=u1.getLogin();
//			PASSWORD=u1.getPassword();
		
		if(USERNAME.equals(name)&&PASSWORD.equals(password)){
			System.out.println("authentification success ...");

			authentificationSuccessFlag=true;
			
		}else{
			authentificationSuccessFlag=false;
			throw new FailedLoginException("authentification Failure....");
		}
		
		//}
		return authentificationSuccessFlag;
		
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
