package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import embadableIDs.RecommendationId;

/**
 * Entity implementation class for Entity: Recommendation
 *
 */
@Entity

public class Recommendation implements Serializable {

	@Id
	private RecommendationId idRecommendation ;
	private String text ;
	private Date date ;
	@ManyToOne
	@JoinColumn(name="idRecommendedPK",insertable=false,updatable=false)
	private User recommended;
	@ManyToOne
	@JoinColumn(name="idRecommenderPK",insertable=false,updatable=false)
	private User recommender;
	private static final long serialVersionUID = 1L;

	public Recommendation() {
		super();
	}

	public RecommendationId getIdRecommendation() {
		return idRecommendation;
	}

	public void setIdRecommendation(RecommendationId idRecommendation) {
		this.idRecommendation = idRecommendation;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getRecommended() {
		return recommended;
	}

	public void setRecommended(User recommended) {
		this.recommended = recommended;
	}

	public User getRecommender() {
		return recommender;
	}

	public void setRecommender(User recommender) {
		this.recommender = recommender;
	}
   
	
	
}
