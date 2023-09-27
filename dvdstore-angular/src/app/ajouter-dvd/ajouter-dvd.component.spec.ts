import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterDvdComponent } from './ajouter-dvd.component';

describe('AjouterDvdComponent', () => {
  let component: AjouterDvdComponent;
  let fixture: ComponentFixture<AjouterDvdComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AjouterDvdComponent]
    });
    fixture = TestBed.createComponent(AjouterDvdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
