import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardPower } from './card-power';

describe('CardPower', () => {
  let component: CardPower;
  let fixture: ComponentFixture<CardPower>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardPower],
    }).compileComponents();

    fixture = TestBed.createComponent(CardPower);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
