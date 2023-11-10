import { Component } from '@angular/core';
import { DvdServiceService, LoginGetAllDTO } from '../dvd-service.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

export interface Login {
  login: string;
}

@Component({
  selector: 'app-mdp-oublie',
  templateUrl: './mdp-oublie.component.html',
  styleUrls: ['./mdp-oublie.component.css']
})
export class MdpOublieComponent {

  usernameObjet: Login[] = [];
  login: string = ''; // Initialisation de username à une chaîne vide
  constructor(private loginService: DvdServiceService, private route: ActivatedRoute) { }
  //login : string = this.route.snapshot.paramMap.get('login');

  loginObjet = {
    "login": '',
    "password": ''
  }

  formCreationcompte(formData: NgForm) {
    console.log(formData.value);
    //this.loginService.updateMDP(formData.value.login, formData.value.password);
    this.loginService.updateMDP(formData.value);
    alert('Success');
  }
}
