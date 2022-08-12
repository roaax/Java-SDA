package com.projectmanager.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.app.models.Project;
import com.projectmanager.app.models.Task;
import com.projectmanager.app.models.User;
import com.projectmanager.app.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepo;
	
	
	public List<Task> findAllTasks(){
		return taskRepo.findAll();
	}
	
	public List<Task> findAllProjectTasks(Project project){
		return taskRepo.findByProject(project);
	}
	

		public Task createTask(Task task, User user, Project project) {
			task.setCreator(user);
			task.setProject(project);
			return taskRepo.save(task);
		}
}