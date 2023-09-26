
import { Injectable } from '@angular/core';
//il faut importer axios cad npm install axios
import { Axios } from 'axios';
import { GenreEnum } from './utils/enum/GenreEnum';

export interface DvdGetAllDTO {
  name: string,
  genre: GenreEnum,
  imgPath: string
}

@Injectable({
  providedIn: 'root'
})
export class DvdServiceService {

  constructor(private axios: Axios) { }

  //on recupere un array d'objet avec getall
  //async pour asynchrone
  //on doit typer promise pour l'asynchronicité
   getAllDvd = async () : Promise<Array<DvdGetAllDTO>> => {
    return this.axios.get('localhost:8080/dvds/');
  }

  getOneDvd =async (id:number) : Promise<DvdGetAllDTO> => {
    return this.axios.get('localhost:8080/dvds/'+ id);
  }
}
