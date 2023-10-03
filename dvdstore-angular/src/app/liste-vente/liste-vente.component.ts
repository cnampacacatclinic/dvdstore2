import { Component } from '@angular/core';
import { DvdServiceService, CustomerGetAllDTO, SaleGetAllDTO, DvdGetAllDTO} from '../dvd-service.service';

export interface Sale {
  id: number;
  FKUsers: number;
  FKMovies: number;
  quantityOfSales: number;
  date: string;
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
  imgPath :string;
  synopsis:string;

}

let fkDvd:number;

@Component({
  selector: 'app-liste-vente',
  templateUrl: './liste-vente.component.html',
  styleUrls: ['./liste-vente.component.css']
})

export class ListeVenteComponent {

  //il va falloir parcourrir les trois tableau pour avoir les ids et les noms en fonctions
  //on les comaparera
  saleToShow: Sale[] = [];
  saleToShow2: Sale[] = [];
  saleToShow3: Sale[] = [];
  customerToShow: Customer[] = [];
  dvdToShow: Dvd[] = [];

  //on aura besoin d'un objet pour pouvoir l'afficher car on le selectionnera par son id
  dvdObj = {
    id:0,
    name: '',
    genre: '',
    quantity : 0,
    price :0,
    imgPath :'',
    synopsis : ''
  }

  customerObj ={
    id:0,
        firstName: '',
        lastName: '',
        mail: '',
        phoneNumber: 0,
        streetNumber: 0,
        streetName: '',
        postcode: 142587,
        city: '',
        voie: ''
  }

  constructor(
    private saleService: DvdServiceService,
    private dvdService: DvdServiceService,
    private customerService: DvdServiceService
  ) {}

  async ngOnInit() {
    const salGetAllDTOs = await this.saleService.getAllSale();
    const customerGetAllDTOs = await this.customerService.getAllCustomer();
    const dvdGetAllDTOs = await this.dvdService.getAllDvd();

    //liste des ventes pour obtenie la clef du dvd
    this.saleToShow2 = salGetAllDTOs.map((value: SaleGetAllDTO) => {
      const sale: Sale = {
        id: value.id,
        FKUsers: 5,
        FKMovies: value.FKMovies,
        date: value.date,
        quantityOfSales: value.quantityOfSales,
        total:value.total
      };
      return sale.FKMovies;
    });

    //liste des ventes pour obtenir la clef du client
    this.saleToShow3 = salGetAllDTOs.map((value: SaleGetAllDTO) => {
      const sale: Sale = {
        id: value.id,
        FKUsers: value.FKUsers,
        FKMovies: value.FKMovies,
        date: value.date,
        quantityOfSales: value.quantityOfSales,
        total:value.total
      };
      return sale.FKUsers;
    });

    //liste complete des ventes
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

    //obtient un dvd en fonction de l'id etranger
    this.dvdService.getOneDvd(Number(this.saleToShow2)).then((response) => {

      if(this.saleToShow!=null){
        const dvd: DvdGetAllDTO = response.data;
        this.dvdObj = {
          id: fkDvd,
          genre: dvd.genre,
          name: dvd.name,
          price: dvd.price,
          quantity: dvd.quantity,
          imgPath :dvd.imgPath,
          synopsis: dvd.synopsis
        }
      return this.dvdObj;
    }else{
      return null;
    }
  });

   

    }//fin du ngOnInit

   
  }//fin de la class ListeVenteComponent
 