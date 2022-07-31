package com.lookify.app.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="lookify")
public class Lookify {


			@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
		    @NotNull
		    @Size(min = 5, max = 20 , message="it has to be at least 5 characters")
		    private String title;
		    @NotNull
		    @Size(min = 5, max = 20,  message="it must be at least 5 characters")
		    private String artist;
		    @NotNull
		    @Min(value=1,  message="it must be a number between 1 and 10")
		    private Integer rating;
		    // This will not allow the createdAt column to be updated after creation
		    @Column(updatable=false)
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date createdAt;
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date updatedAt;
		    
		    
		    
		    public Lookify() {}
			public Lookify(String title,String artist,int rating) {
				this.title = title;
				this.artist = artist;
				this.rating = rating;
			}
			
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
				public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getArtist() {
				return artist;
			}
			public void setArtist(String artist) {
				this.artist = artist;
			}
			public Integer getRating() {
				return rating;
			}
			public void setRating(Integer rating) {
				this.rating = rating;
			}
				@PrePersist
			protected void onCreate() {
				this.createdAt = new Date();
			}
			@PreUpdate
			protected void onUpdate() {
				this.updatedAt = new Date();
			}

}


