import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardMovie } from './card-movie';

describe('CardMovie', () => {
  let component: CardMovie;
  let fixture: ComponentFixture<CardMovie>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardMovie],
    }).compileComponents();

    fixture = TestBed.createComponent(CardMovie);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
