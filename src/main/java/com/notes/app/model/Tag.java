package com.notes.app.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Table(name = "tag")
@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String content;
	
	@ManyToMany(fetch= FetchType.LAZY, mappedBy="tags", targetEntity = Notes.class)
	private Set<Notes> notes;

	public Set<Notes> getNotes() {
		return notes;
	}

	public void setNotes(Set<Notes> note) {
		this.notes = note;
	}

	public Tag() {
	}
	
	public Tag(Integer id, String content, Set<Notes> notes) {
		super();
		this.id = id;
		this.content = content;
		this.notes = notes;
	}

	/**
	 * Constructor to create a Tag with content.
	 * 
	 * @param content the content of the tag
	 */	
	public Tag(String content) {
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
		public void setId(Integer id) {
		this.id = id;
	}
		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
		
		
}
