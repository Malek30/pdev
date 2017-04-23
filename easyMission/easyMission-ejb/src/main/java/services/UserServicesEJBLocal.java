package services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Local;

import entities.Employer;
import entities.Skill;
import entities.User;
import entities.Worker;

@Local
public interface UserServicesEJBLocal {
	public void addUser(User u)throws NoSuchAlgorithmException;
	public void addWorker(Worker w)throws NoSuchAlgorithmException;
	public void addEmployer(Employer E)throws NoSuchAlgorithmException;
	public void updateUser(User u)throws NoSuchAlgorithmException;
	public void updateWorker(Worker w)throws NoSuchAlgorithmException;
	public void updateEmployer(Employer E)throws NoSuchAlgorithmException;
	public void deleteUser(User u);
	public void deleteEmploer(Employer E);
	public void deleteWorker(Worker w);
	public User findUserById(int idUser);
	public User findUserByLogin(String Login);
	public User findUserByMail(String Mail);
	public Employer findEmploerById(int idEmploer);
	public Worker findWorkerById(int idWorker);
	public User findUserByName(String name);
	public Worker findWorkerByName(String name);
	public Employer findEmployerByName(String name);
	public User findUserBYLoginAndPassword(String login ,String pwd)throws NoSuchAlgorithmException ;
	public List<Skill> findAllSkills();
	public List<Worker> findAllWorkers();
	public Skill findSkillByName(String name);
}
