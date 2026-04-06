import { TestBed } from '@angular/core/testing';

import { Superpowers } from './superpowers';

describe('Superpowers', () => {
  let service: Superpowers;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Superpowers);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
