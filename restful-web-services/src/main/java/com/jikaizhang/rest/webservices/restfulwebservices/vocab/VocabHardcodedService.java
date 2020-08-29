package com.jikaizhang.rest.webservices.restfulwebservices.vocab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VocabHardcodedService {
	
	private static List<Vocab> vocabs = new ArrayList<>();
	private static long idCount = 0;
	
	static {
		vocabs.add(new Vocab(++idCount, "abc", "Merci", "Thank you", new Date()));
		vocabs.add(new Vocab(++idCount, "abc", "La nourriture", "The food", new Date()));
		vocabs.add(new Vocab(++idCount, "abc", "Est", "Is", new Date()));
		vocabs.add(new Vocab(++idCount, "abc", "Fantastique", "Fantastic", new Date()));
	}
	
	public List<Vocab> findAll() {
		return vocabs;
	}
	
	public Vocab save(Vocab vocab) {
		// add
		if (vocab.getId() == -1 || vocab.getId() == 0) {
			vocab.setId(++idCount);
			// update the date when a vocabulary is created or updated
			vocab.setDateAdded(new Date());
			vocabs.add(vocab);
		}
		// update
		else {
			deleteById(vocab.getId());
			vocab.setDateAdded(new Date());
			vocabs.add(vocab);
		}
		return vocab;
	}
	
	public Vocab deleteById(long id) {
		Vocab vocab = findById(id);
		if (vocab == null)
			return null;
		if (vocabs.remove(vocab))
			return vocab;
		return null;
	}

	public Vocab findById(long id) {
		for (Vocab vocab : vocabs) {
			if (vocab.getId() == id)
				return vocab;
		}
		return null;
	}
}
