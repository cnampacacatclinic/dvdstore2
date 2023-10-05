import { Component } from '@angular/core';
import { GenreEnum } from './utils/enum/GenreEnum';

export interface Dvd {
  name: string,
  genre: GenreEnum,
  imgPath: string
}


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  //le session est dans sessionStorage et non dans localStorage !!!
  sessionToken : string = sessionStorage.getItem("token") as string; //on a caster  en string : as string
  sessionRole : string = sessionStorage.getItem("role") as string; //on a caster  en string : as string

  //fonction deconnexion
  deconnexion(){
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("role");
    // Supprimer toutes les données de sessionStorage
    //sessionStorage.clear();
  }


  title = 'dvdstore-angular';
  searchText = 'a';


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


  handleSearchInput = (event: any) => {
    this.searchText = event?.target.value
  }

  handleButtonSearchClick = () => {
    console.log(this.searchText)
  }

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