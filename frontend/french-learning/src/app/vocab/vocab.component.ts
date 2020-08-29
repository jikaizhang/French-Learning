import { Component, OnInit } from '@angular/core';
import { VocabDataService } from '../service/data/vocab-data.service';
import { Vocab } from '../vocab-list/vocab-list.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-vocab',
  templateUrl: './vocab.component.html',
  styleUrls: ['./vocab.component.css']
})
export class VocabComponent implements OnInit {

  id: number
  vocab: Vocab

  constructor(
    private vocabService: VocabDataService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.vocab = new Vocab(this.id, "", "", new Date());
    if (this.id != -1) {
      this.vocabService.retrieveVocab('abc', this.id).subscribe(
        data => this.vocab = data
      )
    }
  }

  saveVocab() {
    if (this.id == -1) {
      // create vocab
      this.vocabService.createVocab('abc', this.vocab).subscribe(
        data => {
          this.router.navigate(['vocabs'])
        }
      )
    }
    else {
      this.vocabService.updateVocab('abc', this.id, this.vocab).subscribe(
        data => {
          this.router.navigate(['vocabs'])
        }
      )
    }
  }
}
