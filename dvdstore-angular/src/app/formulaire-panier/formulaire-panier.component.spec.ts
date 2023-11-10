import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulairePanierComponent } from './formulaire-panier.component';

describe('FormulairePanierComponent', () => {
  let component: FormulairePanierComponent;
  let fixture: ComponentFixture<FormulairePanierComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormulairePanierComponent]
    });
    fixture = TestBed.createComponent(FormulairePanierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
