package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import embadableIDs.ApplicationId;

/**
 * Entity implementation class for Entity: Application
 *
 */
@Entity

public class Application implements Serializable {

	@Id
	private ApplicationId idApplication;
	private Date date;
	private String text ;
	@ManyToOne
	private Mission mission;
	@ManyToOne
	private Worker worker ;
	private static final long serialVersionUID = 1L;

	public Application() {
		super();
	}

	public ApplicationId getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(ApplicationId idApplication) {
		this.idApplication = idApplication;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
   
}
