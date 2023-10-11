import { Component } from '@angular/core';
import { DvdServiceService} from '../dvd-service.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  constructor(private dvdService: DvdServiceService,private router: Router){}

  loginObjet={
    "username": '',
     "password": ''
  }

  async  formConnexion(formData: NgForm) {
    //on affiche dans la console le contenu du formulaire
    //console.log(formData.value);
    //on envoie le contenu à la methode connexion dans le service
    this.dvdService.connexion(formData.value);
    //on recupére la reponse de la requete avec la methode reponseConnexion dans le service
    const data = await this.dvdService.reponseConnexion(formData.value);
    //on affiche dans la console la reponse
    //console.log('data : '+data);
    //on range le token dans une session
    sessionStorage.setItem("token",data.token)
    //on fait de meme pour le role
    //console.log(data.user.roles[0].name);
    const userRole = data.user.roles[0].name;
    sessionStorage.setItem("role",userRole);
    
    //si les session existent
    if(sessionStorage.getItem("role")!==null && sessionStorage.getItem("token")!==null){
      //on redirige vers la page admin-home
      this.router.navigate(['/admin-home']);
    }else{
      alert('La connexion a échoué !');
    }

  }


}
