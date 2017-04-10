package security;

import java.security.CryptoPrimitive;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import entities.User;
import services.UserServicesEJBLocal;
import services.UserServicesEJBRemote;

public class Main {
	@EJB
	private static UserServicesEJBRemote us;
	
	public static void main(String[] args) throws NoSuchAlgorithmException {

//		System.setProperty("java.security.auth.login.config", "jaas.config");
//		loginModule l=new loginModule();
////		
//		callbackHandler x=new callbackHandler();
//		LoginContext loginContext=null;
//		x.setLogin("malek1");
//		x.setPwd("123");
//		boolean flag=false;
//
//		 try {
//			loginContext=new LoginContext("EM",x);
//			loginContext.login();
//		} catch (LoginException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//User u=us.findUserByLogin("malek1");
		String x=cryptepdw("123");
		
		System.out.println(x);
		
	}
	public static String cryptepdw(String code) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
          md.update(code.getBytes());
          
          byte byteData[] = md.digest();
          //convert the byte to hex format method 2
          StringBuffer hexString = new StringBuffer();
          for (int i=0;i<byteData.length;i++) {
              String hex=Integer.toHexString(0xff & byteData[i]);
              if(hex.length()==1) hexString.append('0');
              hexString.append(hex);
              }
              String pwd1=hexString.toString();
              return pwd1;
    }

}
