import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Vocab } from 'src/app/vocab-list/vocab-list.component';
import { VOCAB_JPA_API_URL } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class VocabDataService {

  constructor(
    private http: HttpClient
  ) { }

  retrieveAllVocabs(username) {
    return this.http.get<Vocab[]>(`${VOCAB_JPA_API_URL}/users/${username}/vocabs`);
  }

  deleteVocab(username, id) {
    return this.http.delete(`${VOCAB_JPA_API_URL}/users/${username}/vocabs/${id}`);
  }

  retrieveVocab(username, id) {
    return this.http.get<Vocab>(`${VOCAB_JPA_API_URL}/users/${username}/vocabs/${id}`);
  }

  updateVocab(username, id, vocab) {
    return this.http.put(`${VOCAB_JPA_API_URL}/users/${username}/vocabs/${id}`, vocab);
  }

  createVocab(username, vocab) {
    return this.http.post(`${VOCAB_JPA_API_URL}/users/${username}/vocabs`, vocab);
  }
}
