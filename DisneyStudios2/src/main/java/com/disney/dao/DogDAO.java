package com.disney.dao;

import java.util.List;

import com.disney.model.Dog;

public interface DogDAO {

	public List<Dog> getDogsByBreed(String breed);
	
	public void like(String picurl, int count);
	
	public void unlike(String picurl, int count);
	
	public int likeCount(String picurl);
	
	public int unlikeCount(String picurl);
	
	public Dog getDog(String picurl);
	
	public void updateDog(Dog dog);
	
	public void addDog(Dog dog);
	
	public void deleteDog(Dog dog);
}
