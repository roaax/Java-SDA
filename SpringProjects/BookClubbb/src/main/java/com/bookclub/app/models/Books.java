package com.bookclub.app.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 2, max = 200)
    private String title;
    
    @NotNull
    @Size(min = 2, max = 200)
    private String authorName;
    
    @NotNull
    @Size(min = 2, max = 200)
    private String thoughts;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // Relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    public Books() {}
    public Books( String title,String authorName ,String thoughts, User user) {
        this.title = title;
        this.authorName = authorName;
        this.thoughts=thoughts;
        this.user = user;
    }


    //    getters and setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getThoughts() {
        return thoughts;
    }
    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }
    // other getters and setters removed for brevity
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
}
