import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailDvdComponent } from './detail-dvd.component';

describe('DetailDvdComponent', () => {
  let component: DetailDvdComponent;
  let fixture: ComponentFixture<DetailDvdComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetailDvdComponent]
    });
    fixture = TestBed.createComponent(DetailDvdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
