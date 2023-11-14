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


  constructor(private dvdService: DvdServiceService,private route : ActivatedRoute) {}

  public maFonction() {
    return "Hello World!";
  }

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
  }

}