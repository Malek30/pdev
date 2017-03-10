package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Mission
 *
 */
@Entity

public class Mission implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMission;
	
	@ManyToOne
	private Employer employer;

	private String title;

	private String description;
	private String skills;
	private String field;
	private float price;
	private String state;
	private Date startDate;
	private Date endDate;
	private Worker worker;
	private String missionType;
	private Boolean local;

	@OneToMany(mappedBy = "mission")
	private List<Suggestion> suggestions;
	@OneToMany(mappedBy="mission")
	private List<Application> applications;
	@OneToMany(mappedBy="mission")
	private List<Repport> repports;

	private static final long serialVersionUID = 1L;

	public Mission() {
		super();
	}

	public int getIdMission() {
		return this.idMission;
	}

	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public String getMissionType() {
		return missionType;
	}

	public void setMissionType(String missionType) {
		this.missionType = missionType;
	}

	public Boolean getLocal() {
		return local;
	}

	public void setLocal(Boolean local) {
		this.local = local;
	}

}
