package com.notes.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.notes.app.exception.NotesException;
import com.notes.app.model.Notes;
import com.notes.app.repo.NotesRepo;
import com.notes.app.repo.TagRepo;

@Component
public class NotesService {
	
	@Autowired
	private NotesRepo notesRepository;
	
	@Autowired
	private TagRepo tagRepository;

	public List<Notes> getAllNotes() throws NotesException {
		
		List<Notes> notes = notesRepository.findAll();
		if (notes.isEmpty()) {
			throw new NotesException("No notes found");
		}
		return notes ;
	}

	public Notes createNote(Notes note) {

		if (note != null) {
			
			note.setCreatedAt(LocalDateTime.now());
			
			note.setUpdatedAt(LocalDateTime.now());
			
				return notesRepository.save(note);// Assuming a default user ID for simplicity
			
			
		}
		return null;
	}

	public Notes getNoteById(Integer id) throws NotesException {
		notesRepository.findById(id).orElseThrow(() -> new NotesException("Note not found with id: " + id));
		return null;
	}

	public Notes updateNote(Integer id, Notes note) {
		if (notesRepository.existsById(id)) {
			note.setId(id);
			return notesRepository.save(note);
		}
		return null;
	}

	public void deleteNote(Integer id) throws NotesException {
		if (!notesRepository.existsById(id)) {
			throw new NotesException("Note not found with id: " + id);
		}
		notesRepository.deleteById(id);
		
	}

}
