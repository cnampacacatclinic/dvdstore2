import { Component } from '@angular/core';
import { DvdServiceService, PanierGetAllDTO} from '../dvd-service.service';

export interface Panier {
  id_panier:number;
  idClient:number;
  idDvd:number;
  prixUnitaire:number;
  total:number;
  date:Date;
  quantity:number;
}

@Component({
  selector: 'app-liste-panier',
  templateUrl: './liste-panier.component.html',
  styleUrls: ['./liste-panier.component.css']
})
export class ListePanierComponent {

 panierToShow:  Panier[] = [];

  constructor(private  panierService: DvdServiceService) {}

  async ngOnInit() {
    
    const  panierGetAllDTOs = await this. panierService.getAllPanier();
    this.panierToShow =  panierGetAllDTOs.map((value: PanierGetAllDTO) => {
      const  panier:  Panier = {
        id_panier: value.id_panier,
        idClient:value.idClient,
        idDvd:value.idDvd,
        prixUnitaire:value.prixUnitaire,
        total:value.total,
        date:value.date,
        quantity:value.quantity
      };
      return  panier;
    });
  }

}
