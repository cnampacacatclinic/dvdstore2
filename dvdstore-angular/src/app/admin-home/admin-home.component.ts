import { Component, OnInit } from '@angular/core';
import { DvdServiceService, DvdGetAllDTO } from '../dvd-service.service';
import { BearerTokenInterceptorService } from '../bearer-token-interceptor.service';

export interface Dvd {
  id: number;
  genre: string;
  name: string;
  price: number;
  quantity: number;
  synopsis: string;
  imgPath :string;
}

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {
  dvdToShow: Dvd[] = [];

  constructor(private dvdService: DvdServiceService,private httpService: BearerTokenInterceptorService) {}
  id: string | null='0';

  //le session est dans sessionStorage et non dans localStorage !!!
  sessionToken : string = sessionStorage.getItem("token") as string; //on a caster  en string : as string
  sessionRole : string = sessionStorage.getItem("role") as string; //on a caster  en string : as string

  async ngOnInit() {
    const dvdGetAllDTOs = await this.dvdService.getAllDvd();
    
    // Mapping des données
    this.dvdToShow = dvdGetAllDTOs.map((value: DvdGetAllDTO) => {
      const dvd: Dvd = {
        id: value.id,
        genre: value.genre,
        name: value.name,
        price: value.price,
        quantity: value.quantity,
        synopsis: value.synopsis,
        imgPath :value.imgPath
      };
      return dvd;
    });

    /**const secureResourceUrl = 'https://votre-api.com/resource';
    const bearerToken = 'votre-jeton-bearer'; // Remplacez par le véritable jeton Bearer

    this.httpService.makeSecureRequest(secureResourceUrl, bearerToken)
      .then((data) => {
        // Traitez les données ici
        console.log(data);
      })
      .catch((error) => {
        // Gérez les erreurs ici
        console.error(error);
      });
  }/**/
  
  }
}