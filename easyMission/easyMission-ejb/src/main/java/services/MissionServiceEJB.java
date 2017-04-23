package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Mission;
import entities.Skill;


/**
 * Session Bean implementation class MissionServiceEJB
 */
@Stateless
@LocalBean
public class MissionServiceEJB implements MissionServiceEJBRemote, MissionServiceEJBLocal {
	
	@PersistenceContext()
	EntityManager em;
    /**
     * Default constructor. 
     */
    public MissionServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddMission(Mission m) {
		em.persist(m);
		
	}

	@Override
	public void UpdateMission(Mission m) {
		em.merge(m);
		
	}

	@Override
	public void DeleteMission(Mission m) {
		em.remove(em.merge(m));
		
	}

	@Override
	public Mission findMissionId(int id) {
		return em.find(Mission.class,id);
	}

	@Override
	public Mission findMissionByName(String name) {
		
		return em.createQuery("select m from Mission m where m.title=:nom",Mission.class).setParameter("nom", name).getSingleResult();
	}

	@Override
	public List<Mission> findMission() {
		return  em.createQuery ("select m from Mission m ",Mission.class).getResultList();
		/*TypedQuery<Mission> TQM = em.createQuery("SELECT m FROM Mission",Mission.class);
		return TQM.getResultList();
		*/
	}

	@Override
	public List<Skill> findAllSkills() {
		
		 return em.createQuery("select DISTINCT c from Skill c",Skill.class).getResultList();
	}

	@Override
	public void addSkill(Skill s) {
		em.persist(s);
		
	}

}
