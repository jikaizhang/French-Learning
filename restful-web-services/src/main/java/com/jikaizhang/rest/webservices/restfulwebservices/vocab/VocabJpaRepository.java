package com.jikaizhang.rest.webservices.restfulwebservices.vocab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocabJpaRepository extends JpaRepository<Vocab, Long> {
	List<Vocab> findByUsername(String username);
}
