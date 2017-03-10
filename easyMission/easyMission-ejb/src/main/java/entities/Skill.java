package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Skill
 *
 */
@Entity

public class Skill implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSkill;
	private String name;	
	@ManyToMany(mappedBy="skills")
	private List<Worker> workers;
	private static final long serialVersionUID = 1L;

	public Skill() {
		super();
	}  

	public Skill(String name) {
		super();
		this.name = name;
	}

	public int getIdSkill() {
		return this.idSkill;
	}

	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<Worker> getWorkers() {
		return workers;
	}
	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}
	@Override
	public String toString() {
		return "" + name ;
	}
   
}
