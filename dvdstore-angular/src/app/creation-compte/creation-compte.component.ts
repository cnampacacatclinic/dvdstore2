import { Component } from '@angular/core';
import { DvdServiceService} from '../dvd-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-creation-compte',
  templateUrl: './creation-compte.component.html',
  styleUrls: ['./creation-compte.component.css']
})
export class CreationCompteComponent {

  constructor(private dvdService: DvdServiceService){}

  loginObjet={
    "username": '',
     "password": ''
  }

  formCreationcompte(formData: NgForm) {
      console.log(formData.value);
      this.dvdService.register(formData.value);
      alert('Success');
  }

}
