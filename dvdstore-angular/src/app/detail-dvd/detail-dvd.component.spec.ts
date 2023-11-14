import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DetailDvdComponent } from './detail-dvd.component';
export interface Dvd {
  id: number;
  genre: string;
  name: string;
  price: number;
  quantity: number;
  synopsis: string;
  imgPath :string;
}

describe('DetailDvdComponent', () => {
  let component: DetailDvdComponent;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailDvdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    const fixture = TestBed.createComponent(DetailDvdComponent);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('devrait return un dvd...', () => {
    const dvd: Dvd = {
          id: 1,
          genre: 'horreur',
          name: 'Amityville, la maison du diable',
          price: 10.5,
          quantity: 1800,
          imgPath :'2dvd.jpg',
          synopsis: 'En 2048. Doug Quaid rêve chaque nuit qu\'il est sur la planète Mars à la recherche de la belle Melina. Sa femme, Lori, s\'efforce de dissiper ce fantasme. Doug va bientôt s\'apercevoir que son rêve était artificiel et que sa femme est une espionne chargée de'
        }
    expect(component.dvd).toEqual(dvd as any);
  });
});