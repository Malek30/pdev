package security;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import entities.User;
import entities.Worker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * Session Bean implementation class SecurityServiceEJB
 */
@Stateful
@LocalBean
public class SecurityServiceEJB implements SecurityServiceEJBRemote, SecurityServiceEJBLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public SecurityServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public User getConnection(String login, String pwd) {
		User u=null;
		System.setProperty("java.security.auth.login.config", "jaas.config");
		
//		
		callbackHandler x=new callbackHandler();
		LoginContext loginContext=null;
		x.setLogin(login);
		x.setPwd(pwd);
		boolean flag=false;

		 try {
			loginContext=new LoginContext("EM",x);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
//			
//		
			try {
				loginContext.login();
				
				
				//flag=true;
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			
//			 
//		
		return u;
	}

	@Override
	public boolean UserExist(String Login) {
		boolean flag = false;
		User u=null;
		u=em.createQuery("select c from User c where c.Login=:pname",User.class)
		.setParameter("pname", Login).getSingleResult();
		if(u!=null){
			flag=true;
		}
		return flag;
				
	}

}
