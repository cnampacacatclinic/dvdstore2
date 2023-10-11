import { Injectable } from '@angular/core';

import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private router: Router) {}
  sessionToken : string = sessionStorage.getItem("token") as string;

  canActivate(): boolean {
    if (this.sessionToken) {
      return true;
    } else {
      //on redirige vers la page d'acceuil
      this.router.navigate(['/']);
      return false;
    }
  }


}
