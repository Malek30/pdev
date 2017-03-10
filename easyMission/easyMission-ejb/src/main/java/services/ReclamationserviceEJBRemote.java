package services;

import javax.ejb.Remote;

import entities.Repport;

@Remote
public interface ReclamationserviceEJBRemote {
	public void addReclamation(Repport r);
	public void updateReclamation(Repport r);
	public void removeReclamation(Repport r);
	public void displayReclamation(Repport r);

}
