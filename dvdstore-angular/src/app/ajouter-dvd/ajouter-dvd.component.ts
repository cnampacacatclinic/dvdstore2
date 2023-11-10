import { Component } from '@angular/core';
import { DvdServiceService} from '../dvd-service.service';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-ajouter-dvd',
  templateUrl: './ajouter-dvd.component.html',
  styleUrls: ['./ajouter-dvd.component.css']
})
export class AjouterDvdComponent {

  constructor(private dvdService: DvdServiceService) {}
  dvdObj={
    genre:'',
    name:'',
    price:'',
    quantity:'',
    synopsis: '',
    imgPath : ''
  }
  
  form2(formData: NgForm) {
    if(formData.value.name!=''||formData.value!=null){
      console.log(formData.value);
      this.dvdService.addDvd(formData.value);
      alert('Success');
    }else{
      alert('Veuillez remplir tous les champs');
    }
  }

}
