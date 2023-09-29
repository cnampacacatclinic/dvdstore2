import { Component } from '@angular/core';
import { DvdServiceService,DvdGetAllDTO} from '../dvd-service.service';
import { NgForm } from '@angular/forms';

//il nous faut la liste des dvd et la liste des clients
export interface Dvd {
  id: number;
  genre: string;
  name: string;
  price: number;
  quantity: number;
}

@Component({
  selector: 'app-creer-vente',
  templateUrl: './creer-vente.component.html',
  styleUrls: ['./creer-vente.component.css']
})
export class CreerVenteComponent {
  constructor(private dvdService: DvdServiceService) {}
  dvdToShow: Dvd[] = [];
  saleObjet={
    id: 0,
    FKUsers: 0,
    FKMovies: 0,
    quantityOfSales: 0,
    date:Date.now()
  }
  formCreateSale(formData: NgForm) {
    //on change en numerique les valuer des input qui sont en string
    formData.value.FKMovies = Number(formData.value.FKMovies);
    formData.value.FKUsers = Number(formData.value.FKUsers);
    console.log(formData.value);
    this.dvdService.addSale(formData.value);
    //alert('Success');
  }

  async ngOnInit() {
    const dvdGetAllDTOs = await this.dvdService.getAllDvd();

    // Mapping des données
    this.dvdToShow = dvdGetAllDTOs.map((value: DvdGetAllDTO) => {
      const dvd: Dvd = {
        id: value.id,
        genre: value.genre,
        name: value.name,
        price: value.price,
        quantity: value.quantity
      };
      return dvd;
    });
  }
}
