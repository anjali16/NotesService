package com.notes.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notes.app.model.Notes;

@Repository
public interface NotesRepo extends JpaRepository<Notes, Integer> {

	
	// Define custom query methods here if needed
	// For example, you can define methods to find notes by title, content, etc.
	// Example: List<Notes> findByTitle(String title);

}
