package security;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface SecurityServiceEJBRemote {
	public boolean UserExist(String Login );
	public User getConnection(String login, String pwd);
	

}
