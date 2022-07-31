package com.lookify.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lookify.app.models.Lookify;

public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	List<Lookify> findAll();
	List<Lookify> findByArtist(String artist);
	List<Lookify> findTop10ByOrderByRatingDesc();

}
