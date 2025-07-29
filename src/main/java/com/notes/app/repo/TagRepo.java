package com.notes.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notes.app.model.Tag;

public interface TagRepo extends JpaRepository<Tag, Long> {
	
	public Tag findByContent(String content);

	// Define custom query methods here if needed
	// For example, you can define methods to find tags by name, etc.
	// Example: List<Tag> findByName(String name);

}
