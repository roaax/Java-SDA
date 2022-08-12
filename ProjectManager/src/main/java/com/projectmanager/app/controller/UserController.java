package com.projectmanager.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.projectmanager.app.models.LoginUser;
import com.projectmanager.app.models.Project;
import com.projectmanager.app.models.Task;
import com.projectmanager.app.models.User;
import com.projectmanager.app.services.ProjectService;
import com.projectmanager.app.services.TaskService;
import com.projectmanager.app.services.UserService;


    
@Controller
public class UserController {
	@Autowired
	private ProjectService projectServ;
    @Autowired
    private UserService userServ;
    
    @Autowired
    private TaskService taskServ;
    
//    ------------------- Login and Registration ----------------
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
	  }
//  -------------------------- Main Page ---------------------------
	    @GetMapping("/dashboard")
		public String index(Model model, HttpSession session) {
			Long id = (Long)session.getAttribute("user_id");
			if(id != null) {
				User user = userServ.findUserById(id);
				model.addAttribute("user", user);
//				List<Project> allProjects = 
				List<Project> userProjects = projectServ.findAllProjectsByUser(user);
				List<Project> otherProjectts = projectServ.findAllProjectsByUserNotIn(user);		
				List<Project> joinProject = projectServ.findAllProjectsByUserJoin(user);
//				userProjects.addAll(joinProject);
				model.addAttribute("userProjects", userProjects);
				model.addAttribute("otherProjets", otherProjectts);
				model.addAttribute("allProjects", projectServ.findAllProjects());
				model.addAttribute("joinProject", joinProject);

	    		return "dashboard.jsp";
	    	}
	    	else {
	    		return "redirect:/";
	    	}
		}

//    -------------------------- Create New Project ---------------------------
    @GetMapping("/projects/new")
	public String createProject(@ModelAttribute("project") Project project, HttpSession session) {
		Long id = (Long)session.getAttribute("user_id");
		if(id != null) {
			return "project.jsp";			
		}
    	else {
    		return "redirect:/";
    	}
	}
	
	@PostMapping("/projects/new")
	public String creatingProject(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "project.jsp";
		}
		else {
			Long id = (Long) session.getAttribute("user_id");
			User user = userServ.findUserById(id);
			projectServ.createProject(project, user);
			return "redirect:/dashboard";
		}
	}
//  -------------------------- Update Project ---------------------------
	
	@GetMapping("/projects/edit/{id}")
	public String editProject(@ModelAttribute("updatedProject") Project project, @PathVariable("id") Long id, HttpSession session, Model model) {
		Long user_id = (Long) session.getAttribute("user_id");
		if(user_id != null) {
			Project oldProject = projectServ.findProjectById(id);
			model.addAttribute("oldProject", oldProject);
			return "edit.jsp";			
		}
		else {
			return "redirect:/";
		}
	}
	
	@PutMapping("/projects/edit/{id}")
	public String editingProject(@Valid @ModelAttribute("updatedProject") Project project, 
			BindingResult result, @PathVariable("id") Long id, HttpSession session ) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		Long user_id = (Long) session.getAttribute("user_id");
		User user = userServ.findUserById(user_id);
		projectServ.updateProject(project, user , id );
		return "redirect:/dashboard";
	}
	
	
//	-------------------------- Show Project ------------------------
	@GetMapping("/projects/{id}")
	public String showProject(@PathVariable("id")Long id, Model model,
			HttpSession session) {
		Long user_id = (Long)session.getAttribute("user_id");
		if(user_id != null) {
			model.addAttribute("project", projectServ.findProjectById(id));
			return "show.jsp";
		}
    	else {
    		return "redirect:/";
    	}
	}
	
//  -------------------------- Delete Project -----------------------

	@DeleteMapping("/deleteproject/{id}")
	public String deleteProjectt(@PathVariable("id") Long id) {
		projectServ.deleteProject(id);
		return "redirect:/dashboard";
	}
	
//  -------------------------- Join Team ---------------------------
//	@PostMapping("/projects/join/{id}")
//	public String joinTeam(@PathVariable("id")Long id, @ModelAttribute("joinTeam") Project project ,Model model,
//			HttpSession session) {
//		Long user_id = (Long)session.getAttribute("user_id");
//		if(user_id != null) {
//			User user = userServ.findUserById(user_id);
//			Project projectt = projectServ.findProjectById(id);
//			projectServ.joinTeam(projectt, user );
//			return "redirect:/dashboard";
//		}
//    	else {
//    		return "redirect:/";
//    	}
//	}

    @PostMapping("/projects/join/{id}") 
    public String joinTeam(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Project project = projectServ.findProjectById(id);
            User user = userServ.findUserById((Long) session.getAttribute("user_id"));
            projectServ.joinTeam(project, user, id);
            return "redirect:/dashboard";
        } else {
            return "redirect:/";
        }
    }
	
//  -------------------------- Leave Team ---------------------------
//	@PutMapping("/projects/leave/{id}")
//	public String leaveTeam(@PathVariable("id")Long id, @ModelAttribute("joinTeam") Project project ,Model model,
//			HttpSession session) {
//		Long user_id = (Long)session.getAttribute("user_id");
//		if(user_id != null) {
//			User user = userServ.findUserById(user_id);
//			Project projectt = projectServ.findProjectById(id);
//			projectServ.leaveTeam(projectt, user , id);
//			return "redirect:/dashboard";
//		}
//    	else {
//    		return "redirect:/";
//    	}
//	}
//    
//    @PostMapping("/projects/leave/{id}")
//    public String leaveTeam(@PathVariable("id") Long id, HttpSession session) {
//    	Long user_id = (Long)session.getAttribute("user_id");
//        if (user_id != null) {
//            Project project = projectServ.findProjectById(id);
//            User user = userServ.findUserById((Long) session.getAttribute("user_id"));
//            projectServ.leaveTeam(project, user, id);
//            return "redirect:/dashboard";
//        } else {
//            return "redirect:/";
//        }
//    }
	
//  -------------------------- Props Page  | Create Tasks ---------------------------
	@GetMapping("/projects/{id}/tasks")
    public String tasks(@PathVariable("id")Long id,@ModelAttribute("task") Task task,BindingResult result, Model model,
			HttpSession session) {
		Long user_id = (Long)session.getAttribute("user_id");
		if(user_id != null) {
			model.addAttribute("project", projectServ.findProjectById(id));
			model.addAttribute("user", userServ.findUserById(user_id));
			model.addAttribute("tasks", taskServ.findAllTasks());

//            model.addAttribute("tasks", taskServ.findAllProjectTasks(project));
			return "task.jsp";
		}
    	else {
    		return "redirect:/";
    	}
	}
	

	@PostMapping("/projects/{id}/tasks")
    public String createTasks(@PathVariable("id")Long id, @Valid @ModelAttribute("task") Task task,BindingResult result, Model model,HttpSession session) {
		Long user_id = (Long)session.getAttribute("user_id");
		Project project = projectServ.findProjectById(id);
		User user = userServ.findUserById(user_id);
		model.addAttribute("user", user);
		model.addAttribute("project", project);
		model.addAttribute("tasks", taskServ.findAllTasks());
		taskServ.createTask(task, user, project);
		return "redirect:/projects/" + id + "/tasks";

	}
	
//  -------------------------- Logout  ---------------------------
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user_id");
    	return "redirect:/";
    }
    
}
