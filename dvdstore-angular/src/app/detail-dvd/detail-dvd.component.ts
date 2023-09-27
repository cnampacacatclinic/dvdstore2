import { Component } from '@angular/core';
import { GenreEnum } from '../utils/enum/GenreEnum';

export interface Dvd {
  name: string,
  genre: GenreEnum,
  imgPath: string
}

@Component({
  selector: 'app-detail-dvd',
  templateUrl: './detail-dvd.component.html',
  styleUrls: ['./detail-dvd.component.css']
})
export class DetailDvdComponent {

  dvd = {
      name: 'Total recall',
      genre: GenreEnum.ACTION,
      imgPath :'assets/img/2dvd.jpg',
      quantity : 21,
      price :5.99,
      resume : 'En 2048, Doug Quaid rêve chaque nuit qu\'il est sur la planète Mars à la recherche de la belle Melina. Sa femme, Lori, s\'efforce de dissiper ce fantasme. Doug va bientôt s\'apercevoir que son rêve était artificiel et que sa femme est une espionne chargée de veiller à son reconditionnement mental. Il se souvient d\'un séjour réel sur Mars, à l\'époque où il était l\'agent le plus redouté du cruel Coohagen. Il décide de s\'envoler sur Mars à la recherche de son énigmatique passé.'
    }

  constructor() {}

  ngOnInit() {
    this.dvd = this.dvd
  }
}