import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VocabComponent } from './vocab.component';

describe('VocabComponent', () => {
  let component: VocabComponent;
  let fixture: ComponentFixture<VocabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VocabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VocabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
