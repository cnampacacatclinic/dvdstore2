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
  selector: 'app-formulaire-panier',
  templateUrl: './formulaire-panier.component.html',
  styleUrls: ['./formulaire-panier.component.css']
})
export class FormulairePanierComponent {
  
  constructor(private dvdService: DvdServiceService,private customerService: DvdServiceService){}

  panierObj = {
    id: 0,
    idClient:0,
    idDvd:0,
    prixUnitaire:0,
    total:0,
    date:'',
    quantity:0
  };
  dvdObjet={
    id: 0,
    genre: '',
    name: '',
    price: 0,
    quantity: 0
  }

  dvdToShow: Dvd[] = [];
  customerToShow: Customer[] = [];

  form(formData: NgForm) {
    if(formData.value!=null){
      formData.value.id_panier = 0;
      formData.value.idClient = Number(formData.value.idClient);
      formData.value.idDvd = Number(formData.value.idDvd);
      formData.value.prixUnitaire = Number(formData.value.prixUnitaire);
      formData.value.total = 0;
      console.log(formData.value);
      this.dvdService.addPanier(formData.value);
      alert('Success');
    }else{
      alert('Veuillez remplir tous les champs');
    }
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
