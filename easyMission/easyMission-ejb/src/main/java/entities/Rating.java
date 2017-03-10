package entities;

import java.io.Serializable;
import javax.persistence.*;

import embadableIDs.RatingId;

/**
 * Entity implementation class for Entity: Rating
 *
 */
@Entity

public class Rating implements Serializable {

	@Id
	private RatingId idRating ;
	private float mark ;
	@ManyToOne
	private User rater;
	@ManyToOne
	private User rated;
	
	private static final long serialVersionUID = 1L;

	public Rating() {
		super();
	}

	public RatingId getIdRating() {
		return idRating;
	}

	public void setIdRating(RatingId idRating) {
		this.idRating = idRating;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public User getRater() {
		return rater;
	}

	public void setRater(User rater) {
		this.rater = rater;
	}

	public User getRated() {
		return rated;
	}

	public void setRated(User rated) {
		this.rated = rated;
	}
	
   
}
