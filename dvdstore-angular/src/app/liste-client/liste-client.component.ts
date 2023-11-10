import { Component } from '@angular/core';
import { DvdServiceService, CustomerGetAllDTO} from '../dvd-service.service';

export interface Customer {
  id: number;
  firstName: string;
  lastName: string;
  mail: string;
  phoneNumber: string;
  streetNumber: number;
  streetName: string;
  postcode: number;
  city: string;
  voie:string;
}

@Component({
  selector: 'app-liste-client',
  templateUrl: './liste-client.component.html',
  styleUrls: ['./liste-client.component.css']
})
export class ListeClientComponent {
  customerToShow: Customer[] = [];

  constructor(private customerService: DvdServiceService) {}

  async ngOnInit() {
    
    const customerGetAllDTOs = await this.customerService.getAllCustomer();
    this.customerToShow = customerGetAllDTOs.map((value: CustomerGetAllDTO) => {
      const customer: Customer = {
        id: value.id,
        firstName: value.firstName,
        lastName: value.lastName,
        mail: value.mail,
        phoneNumber: value.phoneNumber,
        streetNumber: value.streetNumber,
        streetName: value.streetName,
        postcode: value.postcode,
        city: value.city,
        voie: value.voie
      };
      return customer;
    });
  }

}
