package com.projectmanager.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectmanager.app.models.Project;
import com.projectmanager.app.models.User;
import com.projectmanager.app.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepo;
	
	
//	---------------Find All Project -------------
	public List<Project> findAllProjects(){
		return projectRepo.findAll();
	}
	
//	---------------Find Project By Id -------------
	public Project findProjectById(Long id) {
		Optional<Project> potentialProject = projectRepo.findById(id);
		if(potentialProject.isPresent()) {
			return potentialProject.get();
		}
		else return null;
	}
	
//	---------------Find All Project By User-------------
	public List<Project> findAllProjectsByUser(User user){
		return projectRepo.findByUser(user);
	}
	
//	
////	---------------Find All Project By User Not In  -------------
	public List<Project> findAllProjectsByUserJoin(User user){
		return projectRepo.findByJoinTeamContaining(user);
	}
//	---------------Find All Project By User Not In  -------------
	public List<Project> findAllProjectsByUserNotIn(User user){
		return projectRepo.findByUserNot(user);
	}
	
//	---------------Create Project -------------
	public Project createProject(Project project, User user) {
//		project.setJoinTeam(user);
		project.setUser(user);
		return projectRepo.save(project);
	}
	
//	---------------Update Project -------------
		public Project updateProject(Project project, User user , Long id) {
			Project i = projectRepo.findById(id).get();
			 i.setTitle(project.getTitle());
			 i.setDescription(project.getDescription());
			 i.setDate(project.getDate());
			return projectRepo.save(i);
	}
	
//	---------------Delete Project -------------
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
	
////	---------------Join Team -------------------
	public Project joinTeam(Project project, User user , Long id ) {
		Project optionalProject = findProjectById(id);
		optionalProject.setJoinTeam(user);
		return projectRepo.save(optionalProject);
	}
////	---------------Leave Team -------------------
	public Project leaveTeam(Project project, User user , Long id) {
		Project optionalProject = findProjectById(id);
		optionalProject.leaveJoinTeam(user);
		return projectRepo.save(project);
	}	
}
