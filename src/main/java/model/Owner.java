package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author christophersaid - csaid
 * CIS175 - Spring 2024
 * Feb 24, 2024
 */
@Entity
@Table(name="owner")
public class Owner {
	//	instance variables
	@Id
	@GeneratedValue
	@Column(name="OWNERID")
	private int ownerId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="USERNAME")
	private String userName;
	@OneToMany(mappedBy="owner", cascade=CascadeType.MERGE)
	private List<Animal> animalsOwned;
	
	//	constructors
	public Owner() {
		
	}
	
	public Owner(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		setUserName();
	}
	
	//	getters and setters
	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int id) {
		this.ownerId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName() {
		this.userName = this.firstName + this.lastName;
	}
	
	
}