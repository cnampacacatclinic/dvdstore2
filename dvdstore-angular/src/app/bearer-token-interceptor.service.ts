import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class BearerTokenInterceptorService {

  //le session est dans sessionStorage et non dans localStorage !!!
  sessionToken : string = sessionStorage.getItem("token") as string; //on a caster  en string : as string
  sessionRole : string = sessionStorage.getItem("role") as string; //on a caster  en string : as string

  makeSecureRequest(url: string, token: string) {
    const headers = {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json', // Vous pouvez ajuster les en-têtes en fonction de vos besoins
    };

    return axios.get(url, { headers })
      .then((response) => {
        // Gérer la réponse ici
        console.log(response.data);
        return response.data;
      })
      .catch((error) => {
        // Gérer les erreurs ici
        console.error(error);
        throw error;
      });
  }
}
