package UserJava;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;





public class MainRec {
	public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\\\\\+]+(\\.[\\w\\\\]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }
public static void main(String[] args) throws NamingException {

	/*
	
		InitialContext ctx1=new InitialContext();
		InitialContext ctx2=new InitialContext();
		Object objet2=ctx2.lookup("/easyMission-ear/easyMission-ejb/UserRecommandationServiceEJB!services.UserRecommandationServiceEJBRemote");
		Object objet1=ctx1.lookup("/easyMission-ear/easyMission-ejb/UserServicesEJB!services.UserServicesEJBRemote");
		UserRecommandationServiceEJBRemote proxy=(UserRecommandationServiceEJBRemote)objet2;
		UserServicesEJBRemote proxy1=(UserServicesEJBRemote)objet1;
		
		
		
		User u1=proxy1.findUserById(4);
		User u2=proxy1.findUserById(3);
		//proxy.addUserRecommandation(u1, u2, "nhhh");
		
		//proxy.addUserRecommandation(7,8,"nas tayba");
		
		//System.out.println("done");
	
		List<Recommendation>lrr=new ArrayList<>();
		List<Recommendation>lr=proxy.findAllRecommandation();
		for(Recommendation r : lr){
			if(r.getRecommended().getIdUser()==1){
				//System.out.println("test");
				lrr.add(r);
			}}
		
	*/
String mail="malek.bejaoui@esprit.tn";
 boolean x=isEmail(mail);
 if (x==true) {
	 System.out.println("ok");
	
}else{
	System.out.println("no ok");
}
	
		
	}
}
