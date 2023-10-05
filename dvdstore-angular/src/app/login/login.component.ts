import { Component } from '@angular/core';
import { DvdServiceService} from '../dvd-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  constructor(private dvdService: DvdServiceService){}

  loginObjet={
    "login": '',
     "password": ''
  }

  formConnexion(formData: NgForm) {
      console.log(formData.value);
      this.dvdService.connexion(formData.value);
      alert('Success');
  }

}
