import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierDvdComponent } from './modifier-dvd.component';

describe('ModifierDvdComponent', () => {
  let component: ModifierDvdComponent;
  let fixture: ComponentFixture<ModifierDvdComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifierDvdComponent]
    });
    fixture = TestBed.createComponent(ModifierDvdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
