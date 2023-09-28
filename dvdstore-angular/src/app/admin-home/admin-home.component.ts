import { Component, OnInit } from '@angular/core';
import { DvdServiceService, DvdGetAllDTO } from '../dvd-service.service';


export interface Dvd {
  id: number;
  genre: string;
  name: string;
  price: number;
  quantity: number;
}

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {
  dvdToShow: Dvd[] = [];

  constructor(private dvdService: DvdServiceService) {}

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