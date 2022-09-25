import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookApiComponent } from './book-api.component';

describe('BookApiComponent', () => {
  let component: BookApiComponent;
  let fixture: ComponentFixture<BookApiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookApiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookApiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
