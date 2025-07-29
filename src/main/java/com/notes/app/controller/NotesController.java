package com.notes.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notes.app.exception.NotesException;
import com.notes.app.model.Notes;
import com.notes.app.service.NotesService;

@RequestMapping("/api/v1")
@RestController
public class NotesController  {

	
	@Autowired
	private NotesService service;
	
	@GetMapping("/getNotes")
	public List<Notes> getAllNotes() throws NotesException {
		/*
		 * Authentication authentication =
		 * SecurityContextHolder.getContext().getAuthentication(); // String userName =
		 * authentication.getName(); // User user =
		 * userService.findByUserName(userName); List<JournalEntry> all =
		 * user.getJournalEntries();
		 */
		return service.getAllNotes();
	}
	
	@PostMapping("/addNote")
	public ResponseEntity<Notes>  createNote(@RequestBody Notes note) {
		try {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String userName = authentication.getName();
	        note.setUserName(userName);
	         service.createNote(note);
	       
	         return new ResponseEntity<>(note, HttpStatus.CREATED);
		}catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	    }
	
	@GetMapping("/getNote/{id}")
	public Notes getNoteById(Integer id) throws NotesException {
		return service.getNoteById(id);
	}
	
	@PutMapping("/updateNote/{id}")
	public Notes updateNote(@PathVariable Integer id, @RequestBody Notes note) {
		return service.updateNote(id, note);
	}
	
	@DeleteMapping("/deleteNote/{id}")
	public ResponseEntity<Void> deleteNote(@PathVariable Integer id)  {
		
			try {
				service.deleteNote(id);
				} catch (NotesException e) {}
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}
