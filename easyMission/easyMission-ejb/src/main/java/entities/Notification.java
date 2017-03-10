package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Notification
 *
 */
@Entity

public class Notification implements Serializable {

	   
	@Id
	private int idNotification;
//	@ManyToOne
//	private User notified;
	@OneToOne
	private User notifier;
	private String text;
	private int state;
	private static final long serialVersionUID = 1L;

	public Notification() {
		super();
	}   
	public int getIdNotification() {
		return this.idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}   
	
	public User getNotifier() {
		return this.notifier;
	}

	public void setNotifier(User notifier) {
		this.notifier = notifier;
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}   
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}
   
}
