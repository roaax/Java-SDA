package com.language.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.language.app.models.Language;
import com.language.app.repository.LanguageRepository;


@Service
public class LanguageService {
	
	private final LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguage(){
		return languageRepository.findAll();
	}
	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}
	

	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	public Language updateLanguage(Language language, Long id) {
		Language i = languageRepository.findById(id).get();
		i.setName(language.getName());
		i.setCreator(language.getCreator());
		i.setVersion(language.getVersion());
		return languageRepository.save(i);
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}

}
