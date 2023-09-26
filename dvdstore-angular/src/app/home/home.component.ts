
import { GenreEnum } from '../utils/enum/GenreEnum';
import { DvdServiceService } from './../dvd-service.service';
import { Component, OnInit } from '@angular/core';

export interface Dvd {
  name: string,
  genre: GenreEnum,
  imgPath: string
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  dvds : Array<Dvd>  = [
    {
      name: 'Faites sauter la banque',
      genre: GenreEnum.COMEDIE,
      imgPath :'assets/img/1dvd.jpg'
    },
    {
      name: 'Indiana Jhones',
      genre: GenreEnum.AVENTURE,
      imgPath :'assets/img/6dvd.jpg'
    },

    {
      name: 'Total recall',
      genre: GenreEnum.SCIENCE_FICTION,
      imgPath :'assets/img/2dvd.jpg'
    },

    {
      name: 'Canailles connection',
      genre: GenreEnum.COMEDIE,
      imgPath :'assets/img/3dvd.jpg'
    },

    {
      name: 'Appartement zero',
      genre: GenreEnum.THRILLER,
      imgPath :'assets/img/4dvd.jpg'
    },

    {
      name: 'Den of thieves',
      genre: GenreEnum.ACTION,
      imgPath :'assets/img/5dvd.jpg'
    }
  ]

  dvdToShow : Array<Dvd> = []

  genreFilter: string = ''

  constructor() {}

  handleGenreClickButton = (genre : string) => {
    this.dvdToShow = this.dvds.filter((value) => {
      return value.genre === genre
    })
  }

  ngOnInit() {
    this.dvdToShow = this.dvds
  }
}
