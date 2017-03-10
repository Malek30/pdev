package entities;

import java.io.Serializable;
import java.util.Calendar;
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
	@ManyToOne(cascade = { CascadeType.PERSIST ,CascadeType.MERGE})
	@JoinColumn(name="idRecommendedPK",insertable=false,updatable=false)
	private User recommended;
	@ManyToOne(cascade = { CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="idRecommenderPK",insertable=false,updatable=false)
	private User recommender;
	private static final long serialVersionUID = 1L;

	public Recommendation() {
		super();
	}
	
	public Recommendation(RecommendationId idRecommendation, String text, User recommended,
			User recommender) {
		super();
		this.idRecommendation = idRecommendation;
		this.text = text;
		this.text = text;
		Calendar c = Calendar.getInstance();
		date = c.getTime();
		this.recommended = recommended;
		this.recommender = recommender;
	}
	

//	public Recommendation(String text, User recommended, User recommender) {
//		super();
//		this.text = text;
//		Calendar c = Calendar.getInstance();
//		 date = c.getTime();
//		this.date = date;
//		this.idRecommendation.setIdRecommenderPK(recommender.getIdUser());
//		this.idRecommendation.setIdRecommendedPK(recommended.getIdUser());
//		
//	}


	public RecommendationId getIdRecommendation() {
		return idRecommendation;
	}

	public Recommendation(String text, User recommended, User recommender) {
		super();
		this.text = text;
		Calendar c = Calendar.getInstance();
		date = c.getTime();
		this.recommended = recommended;
		this.recommender = recommender;
		
//		this.idRecommendation.setIdRecommenderPK(recommender);
//		this.idRecommendation.setIdRecommendedPK(recommended);
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
