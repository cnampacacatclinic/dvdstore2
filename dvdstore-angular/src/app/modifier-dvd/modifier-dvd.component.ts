import { Component } from '@angular/core';
import { DvdServiceService, DvdGetAllDTO } from '../dvd-service.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

let id2:number;

export interface Dvd {
  id: number;
  genre: string;
  name: string;
  price: number;
  quantity: number;
  synopsis: string;
  imgPath : string;
}
let idDvd:number;

@Component({
  selector: 'app-modifier-dvd',
  templateUrl: './modifier-dvd.component.html',
  styleUrls: ['./modifier-dvd.component.css']
})

export class ModifierDvdComponent {
  //dvd = {imgPath :'assets/img/2dvd.jpg'}
  
  constructor(private dvdService: DvdServiceService,private route : ActivatedRoute) {}
  
  dvdObj={
    id:'',
    genre:'',
    name:'',
    price:0,
    quantity:0,
    synopsis: '',
    imgPath : ''
  }

  id: string | null='0';

  formUpdate(formData: NgForm) {
    if(formData.value.name!=''||formData.value!=null){
      console.log(formData.value);
      this.dvdService.updateDvd(formData.value.id,formData.value);
      alert('Success');
    }else{
      alert('Veuillez remplir tous les champs');
    }
  }

  deleteClickButton(){
    idDvd=Number(this.route.snapshot.paramMap.get('id'));
    this.dvdService.delDvd(idDvd);
  }

  async ngOnInit() {
    this.id=this.route.snapshot.paramMap.get('id');
    //J'ai du transformer le string en numerique parce que c'est ce qui est attendu
    id2=Number(this.id);
    this.dvdService.getOneDvd(id2).then((response) => {

      if(this.id!=null){
        const dvd: DvdGetAllDTO = response.data;
        this.dvdObj = {
          id: this.id,
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
    console.log(this.dvdObj);
  });
  }
}