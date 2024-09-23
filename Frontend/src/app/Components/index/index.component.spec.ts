import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexhomeComponent } from './index.component';

describe('IndexhomeComponent', () => {
  let component: IndexhomeComponent;
  let fixture: ComponentFixture<IndexhomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IndexhomeComponent]
    });
    fixture = TestBed.createComponent(IndexhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
