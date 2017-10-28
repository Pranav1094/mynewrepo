package com.disney.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Ajay Sunkavalli
 * This class represents a Dog entity class.
 *
 */

@Entity
public class Dog {
	
	/**
	 * ID field auto generated.
	 */
	@Id
	private String picture;
	
	/**
	 * 
	 */
	private String breed;
    
    /**
     * 
     */
	private String color;
    
    /**
     * 
     */
	private String description;
    
    /**
     * 
     */
	private int age;
    
    /**
     * 
     */
	private int up;
    
    /**
     * 
     */
	private int down;

	/**
	 * 
	 */
    Dog()
    {
    	
    }

	/**
	 * @param picture
	 * @param breed
	 * @param color
	 * @param description
	 * @param age
	 * @param up
	 * @param down
	 */
	public Dog(String picture, String breed, String color, String description, int age, int up, int down) {
		super();
		this.picture = picture;
		this.breed = breed;
		this.color = color;
		this.description = description;
		this.age = age;
		this.up = up;
		this.down = down;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the up
	 */
	public int getUp() {
		return up;
	}

	/**
	 * @param up the up to set
	 */
	public void setUp(int up) {
		this.up = up;
	}

	/**
	 * @return the down
	 */
	public int getDown() {
		return down;
	}

	/**
	 * @param down the down to set
	 */
	public void setDown(int down) {
		this.down = down;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dog [picture=" + picture + ", breed=" + breed + ", color=" + color + ", description=" + description
				+ ", age=" + age + ", up=" + up + ", down=" + down + "]";
	}

 
    
    
}
