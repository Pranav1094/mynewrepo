package com.disney.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.disney.model.Dog;
import com.disney.repositories.DogRepository;

@Component
public class DogDAOImpl implements DogDAO {

	@Autowired
	DogRepository dogRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.dao.DogDAO#getDogsByBreed()
	 */

	public List<Dog> getDogsByBreed(String breed) {
		return dogRepository.findByBreed(breed);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.dao.DogDAO#like(java.lang.String, int)
	 */

	public void like(String picurl, int count) {
		System.out.println("data updating " + picurl + "    " + count);
		dogRepository.like(count, picurl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.dao.DogDAO#unlike(java.lang.String, int)
	 */

	public void unlike(String picurl, int count) {
		dogRepository.unlike(count, picurl);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.dao.DogDAO#likeCount(java.lang.String)
	 */

	public int likeCount(String picurl) {
		return dogRepository.getLikeCount(picurl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.dao.DogDAO#unlikeCount(java.lang.String)
	 */

	public int unlikeCount(String picurl) {
		// TODO Auto-generated method stub
		return dogRepository.getUnlikeCount(picurl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.dao.DogDAO#getDog(java.lang.String)
	 */

	public Dog getDog(String picurl) {
		return dogRepository.findOne(picurl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.dao.DogDAO#saveDog(com.disney.model.Dog)
	 */

	public void updateDog(Dog dog) {
		dogRepository.save(dog);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.dao.DogDAO#addDog(com.disney.model.Dog)
	 */

	public void addDog(Dog dog) {
		dogRepository.save(dog);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.dao.DogDAO#deleteDog(com.disney.model.Dog)
	 */

	public void deleteDog(Dog dog) {
		dogRepository.delete(dog);
	}

}
