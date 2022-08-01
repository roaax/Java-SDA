package com.dojoandninjas.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojoandninjas.app.models.Ninja;
import com.dojoandninjas.app.repository.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinja(){
		return ninjaRepository.findAll();
	}
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	

	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	public Ninja updateNinja(Ninja ninja, Long id) {
		Ninja i = ninjaRepository.findById(id).get();
		i.setFirstName(ninja.getFirstName());
		i.setLastName(ninja.getLastName());
		return ninjaRepository.save(i);
	}

	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
}
