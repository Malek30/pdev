package security;

import javax.ejb.Local;

import entities.User;

@Local
public interface SecurityServiceEJBLocal {
	public User getConnection(String login, String pwd);

}
