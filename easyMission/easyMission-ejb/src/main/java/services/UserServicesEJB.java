package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Employer;
import entities.Skill;
import entities.User;
import entities.Worker;


/**
 * Session Bean implementation class UserServicesEJB
 */
@Stateless
@LocalBean
public class UserServicesEJB implements UserServicesEJBRemote, UserServicesEJBLocal {

	@PersistenceContext
	EntityManager em;
    public UserServicesEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addUser(User u) throws NoSuchAlgorithmException {
		String x=Md5(u.getPassword());
		u.setPassword(x);
		em.persist(u);
		
	}

	@Override
	public void addWorker(Worker w) throws NoSuchAlgorithmException {
		String x=Md5(w.getPassword());
		w.setPassword(x);
		em.persist(w);
		
	}

	@Override
	public void addEmployer(Employer E) throws NoSuchAlgorithmException {
		String x=Md5(E.getPassword());
		E.setPassword(x);
		em.persist(E);
		
	}

	@Override
	public void updateUser(User u) throws NoSuchAlgorithmException {
		String x=Md5(u.getPassword());
		u.setPassword(x);
		em.merge(u);
		
	}

	@Override
	public void updateWorker(Worker w) throws NoSuchAlgorithmException {
		String x=Md5(w.getPassword());
		w.setPassword(x);
		em.merge(w);
		
	}
	@Override
	public void updateEmployer(Employer E) throws NoSuchAlgorithmException {
		String x=Md5(E.getPassword());
		E.setPassword(x);
		em.merge(E);
		
	}
	@Override
	public void deleteUser(User u) {
		em.remove(em.merge(u));	
		
	}

	@Override
	public void deleteEmploer(Employer E) {
		em.remove(em.merge(E));	
		
	}

	@Override
	public void deleteWorker(Worker w) {
		em.remove(em.merge(w));	
		
	}

	@Override
	public User findUserById(int idUser) {
		
		return em.find(User.class,idUser);
	}

	@Override
	public Employer findEmploerById(int idEmploer) {

		return em.find(Employer.class,idEmploer);
	}

	@Override
	public Worker findWorkerById(int idWorker) {
		// TODO Auto-generated method stub
		return em.find(Worker.class,idWorker);
	}

	@Override
	public User findUserByName(String name) {
	return	em.createQuery("select c from User c where c.firstName=:pname",User.class)
		.setParameter("pname", name).getSingleResult();
	}

	@Override
	public Worker findWorkerByName(String name) {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Worker c where c.firstName=:pname",Worker.class)
				.setParameter("pname", name).getSingleResult();
	}

	@Override
	public Employer findEmployerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserBYLoginAndPassword(String login, String pwd) throws NoSuchAlgorithmException {
		String x=Md5(pwd);
		return em.createQuery("select c from User c where c.Login=:login and c.password=:pwd",User.class)
		.setParameter("login", login).setParameter("pwd", x).getSingleResult();
	}

	@Override
	public List<Skill> findAllSkills() {
		
		return em.createQuery("select DISTINCT c from  Skill c ",Skill.class).getResultList();
	}

	@Override
	public List<Worker> findAllWorkers() {
		// TODO Auto-generated method stub
		return em.createQuery("select DISTINCT c from  Worker c ",Worker.class).getResultList();
	}

	@Override
	public Skill findSkillByName(String name) {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Skill c where c.name=:pname",Skill.class)
				.setParameter("pname", name).getSingleResult();
	}

	@Override
	public User findUserByLogin(String Login) {
		// TODO Auto-generated method stub
		return em.createQuery("select c from User c where c.Login=:pname",User.class)
				.setParameter("pname", Login).getSingleResult();
	}
	@Override
	public User findUserByMail(String Mail){
		return em.createQuery("select c from User c where c.email=:pname",User.class)
				.setParameter("pname", Mail).getSingleResult();
	}

	@Override
	public String Md5(String pwd) throws NoSuchAlgorithmException {
	
	        MessageDigest md = MessageDigest.getInstance("MD5");
	          md.update(pwd.getBytes());
	          
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
