package com.dojoandninjas.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojoandninjas.app.models.Dojo;
import com.dojoandninjas.app.repository.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojo(){
		return dojoRepository.findAll();
	}
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	

	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalLookify = dojoRepository.findById(id);
		if(optionalLookify.isPresent()) {
			return optionalLookify.get();
		} else {
			return null;
		}
	}
	public Dojo updateDojo(Dojo dojo, Long id) {
		Dojo i = dojoRepository.findById(id).get();
		i.setName(dojo.getName());
		return dojoRepository.save(i);
	}

	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
}
