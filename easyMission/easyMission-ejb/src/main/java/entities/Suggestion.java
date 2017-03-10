package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

import embadableIDs.SuggestionId;



/**
 * Entity implementation class for Entity: Suggestion
 *
 */
@Entity

public class Suggestion implements Serializable {

	@Id
	private SuggestionId idSuggestion;
	
	@ManyToOne
	@JoinColumn(name="idWorkerPK",insertable=false,updatable=false)
	private Worker worker ;
	
	@ManyToOne
	@JoinColumn(name="idEmployerPK",insertable=false,updatable=false)
	private Employer employer;
	
	@ManyToOne
	private Mission mission;	
	
	private String text;
	private Date date;
	
	private static final long serialVersionUID = 1L;

	public Suggestion() {
		super();
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
   
}
