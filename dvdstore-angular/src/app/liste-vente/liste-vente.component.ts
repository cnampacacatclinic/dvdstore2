import { Component } from '@angular/core';

import { DvdServiceService, CustomerGetAllDTO, SaleGetAllDTO, DvdGetAllDTO} from '../dvd-service.service';

export interface Sale {
  id: number;
  FKUsers: number;
  FKMovies: number;
  quantityOfSales: number;
  date: Date;
  total:number;
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
  customerToShow: Customer[] = [];

  dvdMap: Map<number, Dvd> = new Map();

  constructor(
    private saleService: DvdServiceService,
    private dvdService: DvdServiceService,
    private customerService: DvdServiceService
  ) {}

  async ngOnInit() {
    const salGetAllDTOs = await this.saleService.getAllSale();
    const customerGetAllDTOs = await this.customerService.getAllCustomer();
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

    //affiche le client
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

    this.saleToShow = salGetAllDTOs.map((value: SaleGetAllDTO) => {
      const sale: Sale = {
        id: value.id,
        FKUsers: value.FKUsers,
        FKMovies: value.FKMovies,
        date: value.date,
        quantityOfSales: value.quantityOfSales,
        total:value.total
      };
      return sale;
    });

    }//fin du ngOnInit

   
  }//fin de la class ListeVenteComponent
 

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