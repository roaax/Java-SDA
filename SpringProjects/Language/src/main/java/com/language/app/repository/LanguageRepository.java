package com.language.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.language.app.models.Language;


@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	List<Language> findAll();

}
