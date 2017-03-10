package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import embadableIDs.ContactId;

/**
 * Entity implementation class for Entity: Contact
 *
 */
@Entity

public class Contact implements Serializable {

	   
	@Id
	private ContactId idContact;
	
	@ManyToOne
	@JoinColumn(name="idUserPK",insertable=false,updatable=false)
	private User user ;
	
	@ManyToOne
	@JoinColumn(name="idContactPK",insertable=false,updatable=false)
	private User contact ;
	
	private int state;
	private Date date;
	private static final long serialVersionUID = 1L;

	public Contact() {
		super();
	}   
	public ContactId getIdContact() {
		return this.idContact;
	}

	public void setIdContact(ContactId idContact) {
		this.idContact = idContact;
	}   
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
   
}
