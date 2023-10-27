
import { Injectable } from '@angular/core';
//il faut importer axios cad npm install axios
import axios from 'axios';
/*import { GenreEnum } from './utils/enum/GenreEnum';

export interface DvdGetAllDTO {
  name: string,
  genre: GenreEnum,
  imgPath: string
}*/

let id: number;

export interface DvdGetAllDTO {
  id: number;
  genre: string;
  name: string;
  price: number;
  quantity: number;
  synopsis: string;
  imgPath : string;
}
export interface SaleGetAllDTO{
  id: number;
  FKUsers: number;
  FKMovies: number;
  quantityOfSales: number;
  date: string;
  total:number;
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

export interface PanierGetAllDTO {
  id_panier:number;
  idClient:number;
  idDvd:number;
  prixUnitaire:number;
  total:number; 
  date:Date; 
  quantity:number; 
}

//uniquement pour modifier un mot de passe perdu
export interface LoginGetAllDTO {
  username:string;
  password:string;
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
  getAllPanier = async () => {
    return(await axios.get('http://localhost:8080/client/controller/')).data;
  }

  getOneDvd =async (id:number) => {
    return axios.get('http://localhost:8080/dvds/'+ id);
  }

  getOneCustomer =async (id:number) => {
    return axios.get('http://localhost:8080/customer/'+ id);
  }

  getOneSale =async (id:number) => {
    return axios.get('http://localhost:8080/sales/'+ id);
  }

  addDvd = ( formData: FormData ) => {axios.post('http://localhost:8080/dvds/', formData)}

  addPanier = ( formData: FormData ) => {axios.post('http://localhost:8080/client/controller/', formData)}

  updateDvd = ( id:number, formData: FormData ) => {axios.put('http://localhost:8080/dvds/'+ id, formData)}

  delDvd = ( id:number ) => {axios.delete('http://localhost:8080/dvds/'+ id)}

  addCustomer = ( formData: FormData ) => {axios.post('http://localhost:8080/customer/', formData)}

  updateCustomer = ( id:number, formData: FormData ) => {console.log(formData)
    axios.put('http://localhost:8080/customer/'+ id, formData)}

  updateMDP = (formData: FormData) => {axios.put('http://localhost:8080/newmdp', formData)}

  addSale = ( formData: FormData ) => {axios.post('http://localhost:8080/sales/', formData)}

  register = ( formData: FormData ) => {axios.post('http://localhost:8080/register', formData)}

  connexion = ( formData: FormData ) => {axios.post('http://localhost:8080/authorize', formData)}

  reponseConnexion = async  (formData : FormData):Promise<any> => {
    //on recupere le data cad le token etc..
    return (await axios.post('http://localhost:8080/authorize', formData)).data
  }

  //put ou patsh pour update

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
