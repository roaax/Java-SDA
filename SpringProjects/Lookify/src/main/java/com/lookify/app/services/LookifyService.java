package com.lookify.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lookify.app.models.Lookify;
import com.lookify.app.repository.LookifyRepository;


@Service
public class LookifyService {
	private final LookifyRepository lookifyRepository;
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public List<Lookify> allLookify(){
		return lookifyRepository.findAll();
	}
	public Lookify createLookify(Lookify lookify) {
		return lookifyRepository.save(lookify);
	}
	

	public Lookify findLookify(Long id) {
		Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
		if(optionalLookify.isPresent()) {
			return optionalLookify.get();
		} else {
			return null;
		}
	}
	public Lookify updateLookify(Lookify lookify, Long id) {
		Lookify i = lookifyRepository.findById(id).get();
		i.setTitle(lookify.getTitle());
		i.setArtist(lookify.getArtist());
		i.setRating(lookify.getRating());
		return lookifyRepository.save(i);
	}
	
	public List<Lookify> findArtist(String artist) {
		return  lookifyRepository.findByArtist(artist);
	}
	
	
	public List<Lookify> topTen() {
		return  lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	public void deleteLookify(Long id) {
		lookifyRepository.deleteById(id);
	}
}
