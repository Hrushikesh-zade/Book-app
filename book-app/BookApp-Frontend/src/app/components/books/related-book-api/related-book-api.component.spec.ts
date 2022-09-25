import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RelatedBookApiComponent } from './related-book-api.component';

describe('RelatedBookApiComponent', () => {
  let component: RelatedBookApiComponent;
  let fixture: ComponentFixture<RelatedBookApiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RelatedBookApiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RelatedBookApiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
