package com.projectmanager.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectmanager.app.models.Project;
import com.projectmanager.app.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
	List<Project> findAll();
	Optional<Project> findById(Long id);
	List<Project> findByUser(User user);
	List<Project> findByUserNot(User user);
//	List<Project> findByUserJoin(User user);
	List<Project> findByJoinTeamContaining(User user);

}

