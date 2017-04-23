package security;

import java.io.IOException;
import java.util.Map;

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

import delegate.UserServiceDelegate;
import entities.User;
import frames.frame1Controller;

public class loginModule implements LoginModule {
	UserServiceDelegate delegate= new UserServiceDelegate();
	public static  String USERNAME="";
	public static  String PASSWORD="";
	private CallbackHandler callbackHandler=null;
	private boolean authentificationSuccessFlag=false;
	public static User u1=null;
	private Subject subject=null;
	private PrincipalU Principal=null;
	private static final String[][] TEST_USERS={{USERNAME,PASSWORD},{USERNAME,PASSWORD},{USERNAME,PASSWORD}};

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.subject=subject;
		this.callbackHandler=callbackHandler;

	}

	@Override
	public boolean login() throws LoginException {
//		boolean flag=false;
//		Callback[] callbackArray=new Callback[2];
//		callbackArray[0]=new NameCallback("User Name");
//		callbackArray[1]=new PasswordCallback("Password", false);
//		try{
//		u1=delegate.doFindUserByLogin(frame1Controller.log);
//		System.out.println("test log true");}
//		catch(Exception e){
//			System.out.println("authentification Failure ...");
//		}
//		if(u1!=null){
//			USERNAME=u1.getLogin();
//			PASSWORD=u1.getPassword();
//		
//		try {
//			callbackHandler.handle(callbackArray);
//			String name=((NameCallback)callbackArray[0]).getName();
//			String password=new String(((PasswordCallback)callbackArray[1]).getPassword());
//			int i=0;
//			while (i<TEST_USERS.length) {
//				if(TEST_USERS[i][0].equals(name)&& TEST_USERS[i][1].equals(password)){
//					Principal=new PrincipalU(name);
//					System.out.println("authentification success ...");
//					flag=true;
//					break;
//				}
//				i++;
//			}
//			if(flag==false){
//				throw new FailedLoginException("authentification Failure ...");
//			}
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		} catch (UnsupportedCallbackException e) {
//			e.printStackTrace();
//		}
//	}
//		
////		try{
////		u1=delegate.doFindUserByLogin(frame1Controller.log);
////		System.out.println("test log true");}
////		catch(Exception e){
////			System.out.println("authentification Failure ...");
////		}
////		if(u1!=null){
////			USERNAME=u1.getLogin();
////			PASSWORD=u1.getPassword();
////		
////		if(USERNAME.equals(name)&&PASSWORD.equals(password)){
////			System.out.println("authentification success ...");
////			
////			authentificationSuccessFlag=true;
////			
////		}else{
////			authentificationSuccessFlag=false;
////			throw new FailedLoginException("authentification Failure....");
////		}
////		
////		}
////		return authentificationSuccessFlag;
//		return flag;
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
		
		try{
		u1=delegate.doFindUserByLogin(frame1Controller.log);
		System.out.println("test log true");}
		catch(Exception e){
			System.out.println("authentification Failure ...");
		}
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
	}

	@Override
	public boolean commit() throws LoginException {
	
		return authentificationSuccessFlag;
	}

	@Override
	public boolean abort() throws LoginException {
		
		return false;
	}

	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub\
		subject=null;
		return true;
	}

}
