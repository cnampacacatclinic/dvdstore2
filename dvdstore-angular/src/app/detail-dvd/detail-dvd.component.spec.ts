import { TestBed, inject, async } from '@angular/core/testing';
//import { DvdServiceServiceService, DvdGetAllDTO } from '../dvd-service.service';
import { DetailDvdComponent } from './detail-dvd.component';
import { ActivatedRoute } from '@angular/router';

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
  //let DvdServiceService:DvdServiceServiceService;
  let id2:number;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailDvdComponent ],
      //providers: [DvdServiceServiceService]
      providers: [DetailDvdComponent]
    })
    .compileComponents();
  });

  beforeEach(() => {
    const fixture = TestBed.createComponent(DetailDvdComponent);
    component = fixture.componentInstance;
  });

  /*it('should create', () => { 
    expect(component).toBeTruthy();*/
  //});

  it('should return "Hello World!"', () => {
    expect(component.maFonction()).toBe('Hello World!');
  });

  /*it('devrait return un dvd...', () => {
    const dvd: Dvd = {
          id: 1,
          genre: 'horreur',
          name: 'Amityville, la maison du diable',
          price: 10.5,
          quantity: 1800,
          imgPath :'2dvd.jpg',
          synopsis: 'En 2048. Doug Quaid rêve chaque nuit qu\'il est sur la planète Mars à la recherche de la belle Melina. Sa femme, Lori, s\'efforce de dissiper ce fantasme. Doug va bientôt s\'apercevoir que son rêve était artificiel et que sa femme est une espionne chargée de'
        }
      let idDvd2=1;
    expect(component.dvd).toEqual(dvd as any);

    /*DvdServiceService.getOneDvd(1).subscribe((dvd.id) => {
      expect(idDvd2).toEqual({ data: dvd.id })
    });
  });/**/ 

});