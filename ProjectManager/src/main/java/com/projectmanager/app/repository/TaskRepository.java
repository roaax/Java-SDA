package com.projectmanager.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectmanager.app.models.Project;
import com.projectmanager.app.models.Task;
@Repository
public interface TaskRepository extends CrudRepository<Task,Long>{
	List<Task> findAll();
	List<Task> findByProject(Project project);
}

