package com.notes.app.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Table(name = "notes")
@Entity
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notes_id;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String username;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
        name = "note_tags",
        joinColumns = @JoinColumn(name = "notes_id",referencedColumnName = "notes_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "id")
    )
	private Set<Tag> tags;
	
	public Notes() {
	}

	

	public Notes(Integer id, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt, String username,Set<Tag> tags) {
		super();
		this.notes_id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.username = username;
		this.tags = tags; // Initialize tags to avoid NullPointerException
	}



	public Integer getId() {
		return notes_id;
	}

	public void setId(Integer id) {
		this.notes_id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

		public String getUserName() {
		return username;
	}
		public void setUserName(String username) {
		this.username = username;
	}
		public void setTags(Set<Tag> tags) {
		    	this.tags = tags;
		    }
		    public Set<Tag> getTags() {
		    	return tags;
		    }
}
