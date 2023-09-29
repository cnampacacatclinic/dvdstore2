import { Component } from '@angular/core';
import { DvdServiceService} from '../dvd-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-gestion-client',
  templateUrl: './gestion-client.component.html',
  styleUrls: ['./gestion-client.component.css']
})
export class GestionClientComponent {
  constructor(private dvdService: DvdServiceService) {}

  customerObjet={
    id:'',
    firstName:'',
    lastName:'',
    mail:'',
    phoneNumber:'',
    streetNumber:'',
    streetName:'',
    postcode:'',
    city:'',
    voie:''
  }
  formCreateCustomer(formData: NgForm) {
      console.log(formData.value);
      this.dvdService.addCustomer(formData.value);
      alert('Success');
  }
}
