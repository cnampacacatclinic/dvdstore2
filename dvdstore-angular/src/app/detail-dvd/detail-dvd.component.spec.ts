import { TestBed, inject, async, waitForAsync } from '@angular/core/testing';
//import { DvdServiceServiceService, DvdGetAllDTO } from '../dvd-service.service';
import { DetailDvdComponent } from './detail-dvd.component';
import { ActivatedRoute, convertToParamMap } from '@angular/router';


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

      providers: [
      {
          provide: ActivatedRoute,
          //providers: [DetailDvdComponent],
          useValue: {
              snapshot:{
                  paramMap: convertToParamMap({ id:6 }) // id de l'url
              },
          },
      },
  ],
  /**/
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
/*
 it('devrait return un dvd...', waitForAsync(() => {
  const dvd = {
    id: 9,
    genre: 'Action',
    name: 'retest',
    price: 2.4,
    quantity: 6,
    imgPath :'4dvd.jpg',
    synopsis: 'blabla'
  }
//let idDvd2=1;
component.ngOnInit();
expect(component.dvd).toEqual(dvd);
  }));/**/

 it('should return a DVD', async () => {
    component.id = '9';
    await component.ngOnInit();
    expect(component.dvd).toEqual({
      id: 9,
      genre: 'Action',
      name: 'retest',
      price: 2.4,
      quantity: 6,
      imgPath :'4dvd.jpg',
      synopsis: 'blabla',
    });
  });/**/

});