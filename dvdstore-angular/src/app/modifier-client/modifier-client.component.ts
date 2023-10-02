import { Component } from '@angular/core';
import { DvdServiceService,CustomerGetAllDTO} from '../dvd-service.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

let id2:number;

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
  selector: 'app-modifier-client',
  templateUrl: './modifier-client.component.html',
  styleUrls: ['./modifier-client.component.css']
})
export class ModifierClientComponent {
  constructor(private dvdService: DvdServiceService,private route : ActivatedRoute) {}
  
  id2: string | null='0';
  
  customerToShow: Customer | null = null;

  customerObjet={
    id:0,
    firstName:'',
    lastName:'',
    mail:'',
    phoneNumber:'',
    streetNumber:0,
    streetName:'',
    postcode:0,
    city:'',
    voie:''
  }
  formCreateCustomer(formData: NgForm) {
      console.log(formData.value);
      this.dvdService.updateCustomer(formData.value.id,formData.value);
      alert('Success');
  }

  
  async ngOnInit() {

    this.id2=this.route.snapshot.paramMap.get('id');
    //transforme le string en numerique
    id2=Number(this.id2);
    this.dvdService.getOneCustomer(id2).then((response) => {

          const customerObjet: CustomerGetAllDTO = response.data;
          this.customerObjet = {
            id: customerObjet.id=id2,
            firstName: customerObjet.firstName,
            lastName: customerObjet.lastName,
            mail: customerObjet.mail,
            phoneNumber: customerObjet.phoneNumber,
            streetNumber :customerObjet.streetNumber,
            streetName: customerObjet.streetName,
            postcode: customerObjet.postcode,
            city: customerObjet.city,
            voie: customerObjet.voie
        }
      return customerObjet;
    });
    //console.log('id customerObjet  :'+customerObjet);
    console.log('this.id : '+this.id2);
    console.log('id2 : '+id2);

  }//fin ngOnInit
}//fin de la class