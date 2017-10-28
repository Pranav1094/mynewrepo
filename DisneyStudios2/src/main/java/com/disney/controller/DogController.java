package com.disney.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disney.exceptions.DogException;
import com.disney.model.Dog;
import com.disney.service.DogService;

@RestController
public class DogController {

	@Autowired
	DogService dogService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/picturebybreed/{breed}", method = RequestMethod.GET)
	public List<String> getDogsByBreed(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("breed") String breed) {
		logger.info("/picturebybreed/{breed} endpoint called with input {breed}"+breed);
		List<String> pics = null;
		try {
			pics = dogService.getPicsByBreed(breed);
			logger.debug("Total pics returned : "+pics.size());
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			logger.error("Error occured while getting dogs by breed "+e.getMessage());
		}

		return pics;
	}

	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public void like(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam("picurl") String picurl) {
		logger.info("/like endpoint called with input {picurl}"+picurl);
		
		try {
			dogService.vote(picurl, 1);
		} catch (DogException de) {
			/**
			 * TBD : Need to handle other kinds of error codes...
			 */
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/unlike", method = RequestMethod.POST)
	public void unlike(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("picurl") String picurl) {
		logger.info("/unlike endpoint called with input {picurl}"+picurl);
		try {
			dogService.vote(picurl, 0);
		} catch (DogException de) {
			/**
			 * TBD : Need to handle other kinds of error codes...
			 */
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/details", method = RequestMethod.GET, produces = MediaType.TEXT_HTML)
	public String details(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("picurl") String picurl) {
		logger.info("/details endpoint called with input {picurl}"+picurl);
		String details = "";
		try {
			details = dogService.getDogDetails(picurl);
			logger.debug("dog details : "+ details);
		} catch (DogException de) {
			/**
			 * TBD : Need to handle other kinds of error codes...
			 */
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			details = de.getMessage();
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return details;
	}

	@RequestMapping(value = "/likes", method = RequestMethod.GET, produces = MediaType.TEXT_HTML)
	public String likeCount(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("picurl") String picurl) {
		logger.info("/likes endpoint called with input {picurl}"+picurl);
		String likeCount = "";
		try {
			likeCount = dogService.getLikes(picurl);
			logger.debug("like count : "+ likeCount);
		} catch (DogException de) {
			/**
			 * TBD : Need to handle other kinds of error codes...
			 */
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			likeCount = de.getMessage();
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return likeCount;
	}

	@RequestMapping(value = "/breed", method = RequestMethod.GET, produces = MediaType.TEXT_HTML)
	public String dogBreed(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("picurl") String picurl) {
		logger.info("/breed endpoint called with input {picurl}"+picurl);
		String breed = "";
		try {
			breed = dogService.getBreed(picurl);
			logger.debug("breed : "+ breed);
		} catch (DogException de) {
			/**
			 * TBD : Need to handle other kinds of error codes...
			 */
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			breed = de.getMessage();
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return breed;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public void save(HttpServletRequest request, HttpServletResponse response,
			Dog dog)
	{
		try {
			dogService.addDog(dog);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}