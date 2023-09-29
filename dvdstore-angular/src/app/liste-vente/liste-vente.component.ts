import { Component } from '@angular/core';

import { DvdServiceService, CustomerGetAllDTO, SaleGetAllDTO, DvdGetAllDTO} from '../dvd-service.service';

export interface Sale {
  id: number;
  FKUsers: number;
  FKMovies: number;
  quantityOfSales: number;
  //date: string;
}
export interface Customer {
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
export interface Dvd {
  id: number;
  genre: string;
  name: string;
  price: number;
  quantity: number;
}
@Component({
  selector: 'app-liste-vente',
  templateUrl: './liste-vente.component.html',
  styleUrls: ['./liste-vente.component.css']
})

export class ListeVenteComponent {
  saleToShow: Sale[] = [];
  customerMap: Map<number, Customer> = new Map();
  dvdMap: Map<number, Dvd> = new Map();

  constructor(
    private saleService: DvdServiceService,
    private dvdService: DvdServiceService,
    private customerService: DvdServiceService
  ) {}

  async ngOnInit() {
    const salGetAllDTOs = await this.saleService.getAllSale();
    const customerGetAllDTOs = await this.customerService.getAllDvd();
    const dvdGetAllDTOs = await this.dvdService.getAllDvd();

    // Remplir la carte dvdMap
    dvdGetAllDTOs.forEach((dvd: DvdGetAllDTO) => {
      this.dvdMap.set(dvd.id, {
        id: dvd.id,
        genre: dvd.genre,
        name: dvd.name,
        price: dvd.price,
        quantity: dvd.quantity
      });
    });

    // Remplir la carte customerMap
    customerGetAllDTOs.forEach((customer: CustomerGetAllDTO) => {
      this.customerMap.set(customer.id, {
        id: customer.id,
        firstName: customer.firstName,
        lastName: customer.lastName,
        mail: customer.mail,
        phoneNumber: customer.phoneNumber,
        streetNumber: customer.streetNumber,
        streetName: customer.streetName,
        postcode: customer.postcode,
        city: customer.city,
        voie: customer.voie
      });
    });

    // Filtrer les ventes en fonction de customerMap et dvdMap
    this.saleToShow = salGetAllDTOs.map((value: SaleGetAllDTO) => {
      const customer = this.customerMap.get(value.FKUsers);
      const dvd = this.dvdMap.get(value.FKMovies);

      // Filtrer les ventes où le client et le DVD existent
      if (customer && dvd) {
        return {
          id: value.id,
          FKUsers: value.FKUsers,
          FKMovies: value.FKMovies,
          quantityOfSales: value.quantityOfSales,
          customer: customer,
          dvd: dvd
        };
      } else {
        return null; // Ignorer les ventes sans client ou DVD correspondant
      }
    });
  }

  // Méthode pour obtenir le nom du client en fonction de FKUsers
  getCustomerName(FKUsers: number): string {
    const customer = this.customerMap.get(FKUsers);
    return customer ? `${customer.firstName} ${customer.lastName}` : '';
  }

  // Méthode pour obtenir le nom du client en fonction de FKUsers
  getDvdName(FKMovies: number): string {
    const dvd = this.dvdMap.get(FKMovies);
    return dvd ? dvd.name : '';
  }
}
 

  /*saleToShow: Sale[] = [];

  customerToShow: Customer[] = [];

  dvdToShow: Dvd[] = [];

  constructor(private saleService: DvdServiceService,private dvdService: DvdServiceService,private customerService: DvdServiceService) {}

  async ngOnInit() {
    const salGetAllDTOs = await this.saleService.getAllSale();
    const customerGetAllDTOs = await this.customerService.getAllDvd();
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
    // Mapping des données
    this.saleToShow = salGetAllDTOs.map((value: SaleGetAllDTO) => {
      const sale: Sale = {
        id: value.id,
        FKUsers: value.FKUsers,
        FKMovies: value.FKMovies,
        quantityOfSales: value.quantityOfSales
      };
      return sale;
    });
    this.customerToShow = customerGetAllDTOs.map((value: CustomerGetAllDTO) => {
      const customer: Customer = {
        id: value.id,
        firstName: value.firstName,
        lastName: value.lastName,
        mail: value.mail,
        phoneNumber: value.phoneNumber,
        streetNumber: value.streetNumber,
        streetName: value.streetName,
        postcode: value.postcode,
        city: value.city,
        voie: value.voie
      };
      return customer;
    });

    function reponse1(){if(customerGetAllDTOs.id==salGetAllDTOs.FKUsers){
      return true;
    }}
    function reponse2(){
    if(dvdGetAllDTOs.id==salGetAllDTOs.FKMovies){
      reponse1
      return true;
    }}

  }
}*/