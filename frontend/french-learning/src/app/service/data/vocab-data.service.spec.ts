import { TestBed } from '@angular/core/testing';

import { VocabDataService } from './vocab-data.service';

describe('VocabDataService', () => {
  let service: VocabDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VocabDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
