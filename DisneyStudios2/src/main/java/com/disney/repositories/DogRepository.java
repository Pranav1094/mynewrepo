package com.disney.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney.model.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, String> {

	List<Dog> findByBreed(String breed);

	@Query(value = "select up from Dog d where d.picture = :picurl")
	int getLikeCount(@Param("picurl") String picurl);

	@Query(value = "select down from Dog d where d.picture = :picurl")
	int getUnlikeCount(@Param("picurl") String picurl);

	@Query("UPDATE Dog d SET d.up=:likeCount WHERE d.picture = :picurl")
	void like(@Param("likeCount") int likeCount, @Param("picurl") String picurl);
	
	@Query("UPDATE Dog d SET d.down = :down WHERE d.picture = :picurl")
	void unlike(@Param("down") int likeCount, @Param("picurl") String picurl);
}
