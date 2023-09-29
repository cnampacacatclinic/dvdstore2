
import { Injectable } from '@angular/core';
//il faut importer axios cad npm install axios
import axios from 'axios';
/*import { GenreEnum } from './utils/enum/GenreEnum';

export interface DvdGetAllDTO {
  name: string,
  genre: GenreEnum,
  imgPath: string
}*/

export interface DvdGetAllDTO {
  id: number;
  genre: string;
  name: string;
  price: number;
  quantity: number;
}
export interface SaleGetAllDTO{
  id: number;
  FKUsers: number;
  FKMovies: number;
  quantityOfSales: number;
  //date: string;
}
export interface CustomerGetAllDTO {
  id: number;
  firstName: string;
  lastName: string;
  mail: string;
  phoneNumber: string;
  streetNumber: number;
  streetName: string;
  postcode: number;
  city: string;
  voie:string;
}

@Injectable({
  providedIn: 'root'
})
export class DvdServiceService {

  //constructor(private axios: Axios) { }
  constructor(){}

  getAllDvd = async () => {
    return(await axios.get('http://localhost:8080/dvds/')).data;
  }
  getAllCustomer = async () => {
    return(await axios.get('http://localhost:8080/customer/')).data;
  }
  getAllSale = async () => {
    return(await axios.get('http://localhost:8080/sales/')).data;
  }
  addDvd = ( formData: FormData ) => {axios.post('http://localhost:8080/dvds/', formData)}

  addCustomer = ( formData: FormData ) => {axios.post('http://localhost:8080/customer/', formData)}

  addSale = ( formData: FormData ) => {axios.post('http://localhost:8080/sales/', formData)}

  //pu ou patsh pour update

  /*
  //on recupere un array d'objet avec getall
  //async pour asynchrone
  //on doit typer promise pour l'asynchronicité
  getAllDvd = async () : Promise<Array<DvdGetAllDTO>> => {
    return this.axios.get('http://localhost:8080/dvds');
  }

  getOneDvd =async (id:number) : Promise<DvdGetAllDTO> => {
    return this.axios.get('http://localhost:8080/dvds'+ id);
  }
  /**/

}
