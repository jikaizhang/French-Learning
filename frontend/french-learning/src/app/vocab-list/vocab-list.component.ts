import { Component, OnInit } from '@angular/core';
import { VocabDataService } from '../service/data/vocab-data.service';
import { Router } from '@angular/router';

export class Vocab {
  constructor(
    public id: number,
    public french: string,
    public english: string,
    public dateAdded: Date
    // public revised: boolean
  ) {

  }
}

@Component({
  selector: 'app-vocab-list',
  templateUrl: './vocab-list.component.html',
  styleUrls: ['./vocab-list.component.css']
})
export class VocabListComponent implements OnInit {

  vocabs: Vocab[]
  message: string
  showEnglish = true
  showFrench = true
  englishBtnText = "Hide English"
  frenchBtnText = "Hide French"

  constructor(
    private vocabService: VocabDataService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.refreshVocab();
  }

  toggleShowEnglish() {
    if (this.showEnglish && !this.showFrench) {
      this.toggleShowFrench()
    }
    this.showEnglish = !this.showEnglish
    if (this.englishBtnText === "Hide English") {
      this.englishBtnText = "Show English"
    }
    else {
      this.englishBtnText = "Hide English"
    }
  }

  toggleShowFrench() {
    if (!this.showEnglish && this.showFrench) {
      this.toggleShowEnglish()
    }
    this.showFrench = !this.showFrench
    if (this.frenchBtnText === "Hide French") {
      this.frenchBtnText = "Show French"
    }
    else {
      this.frenchBtnText = "Hide French"
    }
  }

  refreshVocab() {
    this.vocabService.retrieveAllVocabs('abc').subscribe(
      response => {
        console.log(response);
        this.vocabs = response;
      }
    )
  }

  deleteVocab(id) {
    this.vocabService.deleteVocab('abc', id).subscribe(
      response => {
        this.message = `Successfully deleted vocabulary #${id}`;
        this.refreshVocab();
      }
    )
  }

  updateVocab(id) {
    this.router.navigate(['vocabs', id])
  }

  addVocab() {
    this.router.navigate(['vocabs', -1])
  }

}
