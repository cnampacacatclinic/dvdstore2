import { Component } from '@angular/core';
import { DvdServiceService,DvdGetAllDTO,CustomerGetAllDTO} from '../dvd-service.service';
import { NgForm } from '@angular/forms';

//il nous faut la liste des dvd et la liste des clients
export interface Dvd {
  id: number;
  genre: string;
  name: string;
  price: number;
  quantity: number;
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
@Component({
  selector: 'app-creer-vente',
  templateUrl: './creer-vente.component.html',
  styleUrls: ['./creer-vente.component.css']
})
export class CreerVenteComponent {
  constructor(private dvdService: DvdServiceService,private customerService: DvdServiceService) {}
  dvdToShow: Dvd[] = [];
  customerToShow: Customer[] = [];
  
  saleObjet={
    id: 0,
    FKUsers: 0,
    FKMovies: 0,
    quantityOfSales: 0,
    date:'',
    total:0
  }

  dvdObjet={
    id: 0,
    genre: '',
    name: '',
    price: 0,
    quantity: 0
  }


  formCreateSale(formData: NgForm) {
    //on change en numerique les valuer des input qui sont en string
    formData.value.FKMovies = Number(formData.value.FKMovies);
    formData.value.FKUsers = Number(formData.value.FKUsers);
    formData.value.total = 0;
    console.log(formData.value);
    this.dvdService.addSale(formData.value);
    alert('Success');
  }

  async ngOnInit() {
    const dvdGetAllDTOs = await this.dvdService.getAllDvd();
    const customerGetAllDTOs = await this.customerService.getAllCustomer();

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
  
  }
}
