package entities;

import entities.User;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employer
 *
 */
@Entity


public class Employer extends User implements Serializable {

	
	private String adress;
	private String company;
	private String companyNumber;
	private String CompanyLogo;
	@OneToMany(mappedBy="employer")
	private List<Mission> missions;
	
	@OneToMany(mappedBy="employer")
	private List<Suggestion> suggestions ;
	
	private static final long serialVersionUID = 1L;

	public Employer() {
		super();
	}   
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}   
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	public String getCompanyLogo() {
		return CompanyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		CompanyLogo = companyLogo;
	}
	@Override
	public String toString() {
		return "Employer [adress=" + adress + ", company=" + company + ", companyNumber=" + companyNumber
				+ ", CompanyLogo=" + CompanyLogo + ", missions=" + missions + ", suggestions=" + suggestions + "]";
	}
	
   
}
