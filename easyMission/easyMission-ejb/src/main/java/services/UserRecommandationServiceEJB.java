package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import embadableIDs.RecommendationId;
import entities.Recommendation;
import entities.User;

/**
 * Session Bean implementation class UserRecommandationServiceEJB
 */
@Stateless
@LocalBean
public class UserRecommandationServiceEJB implements UserRecommandationServiceEJBRemote, UserRecommandationServiceEJBLocal {

	@PersistenceContext
	EntityManager em;
    public UserRecommandationServiceEJB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addUserRecommandation(User u1, User u2, String text) {
//		em.merge(u1);
//		em.merge(u2);
		RecommendationId  rr=new RecommendationId();
		Recommendation r=new Recommendation();
		rr.setIdRecommendedPK(u2.getIdUser());
		rr.setIdRecommenderPK(u1.getIdUser());
		r.setIdRecommendation(rr);
		r.setRecommender(u1);
		r.setRecommended(u2);
		r.setText(text);
		em.persist(em.merge(r));
		
	}



}
