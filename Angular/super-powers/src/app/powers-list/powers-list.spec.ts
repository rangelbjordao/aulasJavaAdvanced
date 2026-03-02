import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PowersList } from './powers-list';

describe('PowersList', () => {
  let component: PowersList;
  let fixture: ComponentFixture<PowersList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PowersList],
    }).compileComponents();

    fixture = TestBed.createComponent(PowersList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
