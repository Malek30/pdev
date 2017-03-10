package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Repport;

/**
 * Session Bean implementation class ReclamationserviceEJB
 */
@Stateless
@LocalBean
public class ReclamationserviceEJB implements ReclamationserviceEJBRemote, ReclamationserviceEJBLocal {
@PersistenceContext
EntityManager em;
    /**
     * Default constructor. 
     */
    public ReclamationserviceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addReclamation(Repport r) {
		em.persist(r);
		
	}

	@Override
	public void updateReclamation(Repport r) {
		em.merge(r);
		
	}

	@Override
	public void removeReclamation(Repport r) {
		em.remove(r);
		
	}

	@Override
	public void displayReclamation(Repport r) {
		
		
	}

}
