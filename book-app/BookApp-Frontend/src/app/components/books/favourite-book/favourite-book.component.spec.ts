import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FavouriteBookComponent } from './favourite-book.component';

describe('FavouriteBookComponent', () => {
  let component: FavouriteBookComponent;
  let fixture: ComponentFixture<FavouriteBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FavouriteBookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FavouriteBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
