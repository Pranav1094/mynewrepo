package com.disney.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.dao.DogDAO;
import com.disney.exceptions.DogException;
import com.disney.model.Dog;

@Service
public class DogServiceImpl implements DogService {

	@Autowired
	DogDAO dogDAO;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<String> getPicsByBreed(String breed) {
		// TODO Auto-generated method stub
		List<Dog> dogs = dogDAO.getDogsByBreed(breed);
		List<String> dogsPics = new ArrayList<String>();
		for (Dog dog : dogs) {
			dogsPics.add(dog.getPicture());
		}
		return dogsPics;
	}

	public void vote(String picurl, int voteType) throws DogException {
		Dog dog = dogDAO.getDog(picurl);
		logger.debug("dog details " + dog);
		logger.info("vote type " + voteType);
		if (dog == null) {
			logger.error("Dog with pic " + picurl + " not found");
			throw new DogException("Dog with pic " + picurl + " not found");
		} else {
			if (voteType == 1) {
				int likeCount = dog.getUp();
				dog.setUp(likeCount + 1);
			} else {
				int unlikeCount = dog.getDown();
				dog.setDown(unlikeCount + 1);
			}
			dogDAO.updateDog(dog);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.service.DogService#getDogDetails(java.lang.String)
	 */
	@Override
	public String getDogDetails(String picurl) throws DogException {
		Dog dog = dogDAO.getDog(picurl);
		logger.debug("dog details " + dog);
		if (dog == null) {
			logger.error("Dog with pic " + picurl + " not found");
			throw new DogException("Dog with pic " + picurl + " not found");
		} else {
			return dog.getDescription();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.service.DogService#getLikes(java.lang.String)
	 */
	@Override
	public String getLikes(String picurl) throws DogException {
		Dog dog = dogDAO.getDog(picurl);
		logger.debug("dog details " + dog);
		if (dog == null) {
			logger.error("Dog with pic " + picurl + " not found");
			throw new DogException("Dog with pic " + picurl + " not found");
		} else {
			int likes = dog.getUp();
			return String.valueOf(likes);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.service.DogService#getBreed(java.lang.String)
	 */
	@Override
	public String getBreed(String picurl) throws DogException {
		Dog dog = dogDAO.getDog(picurl);
		logger.debug("dog details " + dog);
		if (dog == null) {
			throw new DogException("Dog with pic " + picurl + " not found");
		} else {
			return dog.getBreed();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.service.DogService#addDog(com.disney.model.Dog)
	 */
	@Override
	public void addDog(Dog dog) {
		logger.debug("adding dog " + dog);
		dogDAO.addDog(dog);
		logger.info("dog added " + dog.getPicture());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disney.service.DogService#deleteDog(com.disney.model.Dog)
	 */
	@Override
	public void deleteDog(Dog dog) throws DogException {

		Dog d = dogDAO.getDog(dog.getPicture());
		logger.debug("dog details " + dog);
		if (d == null) {
			logger.error("Dog with pic " + dog.getPicture() + " not found");
			throw new DogException("Dog with pic " + dog.getPicture() + " not found");
		} else {
			dogDAO.deleteDog(d);
		}
	}

}
