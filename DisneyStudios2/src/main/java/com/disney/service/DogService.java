package com.disney.service;

import java.util.List;

import com.disney.exceptions.DogException;
import com.disney.model.Dog;

public interface DogService {

	public List<String> getPicsByBreed(String breed);
	
	public void vote(String picurl, int voteType) throws DogException;
	
	public String getDogDetails(String picurl)  throws DogException;
	
	public String getLikes(String picurl) throws DogException;
	
	public String getBreed(String picurl) throws DogException;
	
	public void addDog(Dog dog);
	
	public void deleteDog(Dog dog) throws DogException;
}
