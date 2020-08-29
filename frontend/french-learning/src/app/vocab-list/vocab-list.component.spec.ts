import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VocabListComponent } from './vocab-list.component';

describe('VocabListComponent', () => {
  let component: VocabListComponent;
  let fixture: ComponentFixture<VocabListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VocabListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VocabListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
