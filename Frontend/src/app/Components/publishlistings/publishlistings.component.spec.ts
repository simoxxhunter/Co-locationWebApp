import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublishlistingsComponent } from './publishlistings.component';

describe('PublishlistingsComponent', () => {
  let component: PublishlistingsComponent;
  let fixture: ComponentFixture<PublishlistingsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PublishlistingsComponent]
    });
    fixture = TestBed.createComponent(PublishlistingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
