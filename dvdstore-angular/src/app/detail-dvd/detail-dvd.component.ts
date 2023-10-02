import { Component } from '@angular/core';
import { DvdServiceService, DvdGetAllDTO } from '../dvd-service.service';
import { ActivatedRoute } from '@angular/router';

export interface Dvd {
  id: number;
  genre: string;
  name: string;
  price: number;
  quantity: number;
  synopsis: string;
  imgPath :string;
}
let id2:number;

//id=0;
@Component({
  selector: 'app-detail-dvd',
  templateUrl: './detail-dvd.component.html',
  styleUrls: ['./detail-dvd.component.css']
})
export class DetailDvdComponent {
  id: string | null='0';
  dvd = {
    id:'',
    name: '',
    genre: '',
    quantity : 0,
    price :0,
    imgPath :'',
    synopsis : ''
  }


 // dvdToShow: Dvd | null = null;

  constructor(private dvdService: DvdServiceService,private route : ActivatedRoute) {}

  async ngOnInit() {
    this.id=this.route.snapshot.paramMap.get('id');
    //J'ai du transformer le string en numerique
    id2=Number(this.id);
    this.dvdService.getOneDvd(id2).then((response) => {

      if(this.id!=null){
        const dvd: DvdGetAllDTO = response.data;
        this.dvd = {
          id: this.id,
          genre: dvd.genre,
          name: dvd.name,
          price: dvd.price,
          quantity: dvd.quantity,
          imgPath :dvd.imgPath,
          synopsis: dvd.synopsis
        }
      return dvd;
    }else{
      return null;
    }
    console.log(this.dvd);
  });

    /*
     this.dvdService.getOneDvd(id);
    /** */
  }


  
  /*dvd = {
      name: 'Total recall',
      genre: GenreEnum.ACTION,
      imgPath :'assets/img/2dvd.jpg',
      quantity : 21,
      price :5.99,
      synopsis : 'En 2048, Doug Quaid rêve chaque nuit qu\'il est sur la planète Mars à la recherche de la belle Melina. Sa femme, Lori, s\'efforce de dissiper ce fantasme. Doug va bientôt s\'apercevoir que son rêve était artificiel et que sa femme est une espionne chargée de veiller à son reconditionnement mental. Il se souvient d\'un séjour réel sur Mars, à l\'époque où il était l\'agent le plus redouté du cruel Coohagen. Il décide de s\'envoler sur Mars à la recherche de son énigmatique passé.'
    }

  constructor() {}

  ngOnInit() {
    this.dvd = this.dvd
  }/** */
}