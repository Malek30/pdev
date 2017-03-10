package services;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserRecommandationServiceEJBRemote {
	public void addUserRecommandation(User u1, User u2, String text);
}
