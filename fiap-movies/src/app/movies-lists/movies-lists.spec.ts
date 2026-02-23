import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviesList } from './movies-lists';

describe('MoviesList', () => {
  let component: MoviesList;
  let fixture: ComponentFixture<MoviesList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MoviesList],
    }).compileComponents();

    fixture = TestBed.createComponent(MoviesList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
