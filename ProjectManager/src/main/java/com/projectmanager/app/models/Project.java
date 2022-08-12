package com.projectmanager.app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {
	
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message="Title must be provided")
    @Size(min=3, max=30, message="Project title must be between 3 and 30 characters")
    private String title;
    
    @NotNull
    @Size(min=3, max=30, message="Description must be at least 3 characters")
    private String description;
    
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Future
    private Date date;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
    
    
    @OneToMany(mappedBy="project", fetch=FetchType.LAZY)
    private List<Task> tasks;
   
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_projects", 
	inverseJoinColumns = @JoinColumn(name = "project_id"), 
	joinColumns = @JoinColumn(name = "user_id"))
	private List<User> joinTeam;


//Constructor
public Project() {}

public Project(String title,String description, Date date) {
	this.title = title;
	this.description = description;
	this.date = date;
}

//Getter and Setter
public Long getId() {
	return id;
}


public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public List<User> getJoinTeam() {
	return joinTeam;
}

public void setJoinTeam(User joinTeam) {
	this.joinTeam.add(joinTeam);
}
public void leaveJoinTeam(User joinTeam) {
	this.joinTeam.remove(joinTeam);
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}
@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}


// Get and Set for User
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public List<Task> getTasks() {
	return tasks;
}

public void setTasks(List<Task> tasks) {
	this.tasks = tasks;
}

	
}
