package com.jikaizhang.rest.webservices.restfulwebservices.vocab;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class VocabResource {
	
	@Autowired
	private VocabHardcodedService vocabService;
	
	@GetMapping("/users/{username}/vocabs")
	public List<Vocab> getAllVocabs(@PathVariable String username) {
		return vocabService.findAll();
	}
	
	@GetMapping("/users/{username}/vocabs/{id}")
	public Vocab getVocab(@PathVariable String username, @PathVariable long id) {
		return vocabService.findById(id);
	}
	
	@DeleteMapping("/users/{username}/vocabs/{id}")
	public ResponseEntity<Void> deleteVocab(
			@PathVariable String username, @PathVariable long id) {
		Vocab vocab = vocabService.deleteById(id);
		// success
		if (vocab != null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path="/users/{username}/vocabs/{id}")
	public ResponseEntity<Vocab> updateVocab(
			@PathVariable String username, 
			@PathVariable long id, @RequestBody Vocab vocab) {
		Vocab vocabUpdated = vocabService.save(vocab);
		return new ResponseEntity<Vocab>(vocab, HttpStatus.OK);
	}
	
	@PostMapping(path="/users/{username}/vocabs")
	public ResponseEntity<Void> updateVocab(
			@PathVariable String username, @RequestBody Vocab vocab) {
		Vocab vocabCreated = vocabService.save(vocab);
		// append id to current url
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(vocabCreated.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
