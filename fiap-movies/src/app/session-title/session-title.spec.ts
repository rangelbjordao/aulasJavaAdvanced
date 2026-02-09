import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionTitle } from './session-title';

describe('SessionTitle', () => {
  let component: SessionTitle;
  let fixture: ComponentFixture<SessionTitle>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SessionTitle]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SessionTitle);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
