import { TestBed } from '@angular/core/testing';
import { DvdServiceService } from './dvd-service.service';
import axios, { AxiosResponse, AxiosHeaders } from 'axios';

export interface Dvd {
  id: number;
  genre: string;
  name: string;
  price: number;
  quantity: number;
  synopsis: string;
  imgPath: string;
}

describe('DvdServiceService', () => {
  let service: DvdServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DvdServiceService);
  });

  it('should retrieve a specific DVD', (done: DoneFn) => {
    const dvd: Dvd = {
      id: 500,
      genre: 'Action',
      name: 'test',
      price: 23.8,
      quantity: 500,
      synopsis: 'test resume',
      imgPath: '0dvd.jpg'
    };
  
    const axiosResponse: AxiosResponse<Dvd> = {
      data: dvd,
      status: 200,
      statusText: 'OK',
      headers: { 'Content-Type': 'application/json' } as any,
      config: {
        url: 'http://localhost:8080/dvds/500',
        method: 'GET',
        headers: { 'Content-Type': 'application/json' } as any,
      }
    };
  
    spyOn(axios, 'get').and.returnValue(Promise.resolve(axiosResponse));
  
    service.getOneDvd(500).then((retrievedDvd) => {
      expect(axios.get).toHaveBeenCalledWith('http://localhost:8080/dvds/500');
      expect(retrievedDvd.data).toEqual(dvd);
      done();
    });
  });
  
});
