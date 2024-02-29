package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author christophersaid - csaid
 * CIS175 - Spring 2024
 * Feb 24, 2024
 */
@Entity
@Table(name="animal")
public class Animal {
	//	instance variables
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="TYPE")
	private String type;
	@Column(name="ADOPTION_DATE")
	private LocalDate adoptDate;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="OWNERID")		//	had ChatGPT analyze the code and teach the solution to this
	private Owner owner;
	
	//	constructors
	public Animal() {
		
	}
	
	public Animal(String name, String type, String date) {
		this.name = name;
		this.type = type;
		this.adoptDate = convertStringToLocalDate(date);
	}
	
	//	this is the previous implementation for the adoptDate which didn't account for String input from date picker
//	public Animal(String name, String type, int day, int month, int year) {
//		this.name = name;
//		this.type = type;
//		setAdoptDate(day, month, year);
//	}
	
	//	getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getAdoptDate() {
		return adoptDate;
	}
	
	public void setAdoptDate(LocalDate adoptDate) {
		this.adoptDate = adoptDate;
	}
	
	//	this is the previous implementation for the adoptDate which didn't account for String input from date picker
//	public void setAdoptDate(int day, int month, int year) {
//		LocalDate date = LocalDate.of(year, month, day);
//		this.adoptDate = date;
//	}
	
	//	helper methods
	private LocalDate convertStringToLocalDate(String date) {
		//	utilized ChatGPT to troubleshoot code and explain how pieces worked
		String[] components = date.split("-");
		int[] formattedDates = new int[components.length];
		
		for(int i = 0; i < components.length; i++) {
			formattedDates[i] = Integer.parseInt(components[i]);
		}
		
		int year = formattedDates[0];
		int month = formattedDates[1];
		int day = formattedDates[2];
		
		LocalDate adoptDate = LocalDate.of(year, month, day);
		
		return adoptDate;
		
	}
	
	
}
