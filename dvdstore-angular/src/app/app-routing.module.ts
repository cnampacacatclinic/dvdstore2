import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { DetailDvdComponent } from './detail-dvd/detail-dvd.component';
import { ModifierDvdComponent } from './modifier-dvd/modifier-dvd.component';
import { AjouterDvdComponent } from './ajouter-dvd/ajouter-dvd.component';
import { GestionClientComponent } from './gestion-client/gestion-client.component';
import { CreerVenteComponent } from './creer-vente/creer-vente.component';
import { ListeClientComponent } from './liste-client/liste-client.component';
import { ListeVenteComponent } from './liste-vente/liste-vente.component';
import { ModifierClientComponent } from './modifier-client/modifier-client.component';
import { CreationCompteComponent } from './creation-compte/creation-compte.component';
import { AuthServiceService } from './auth-service.service';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path :'login',
    component: LoginComponent
  },
  {
    path :'admin-home',
    canActivate: [AuthServiceService], //la page ne s'affichera que si on à le token
    component: AdminHomeComponent
  },
  {
    path :'detail-dvd/:id',
    canActivate: [AuthServiceService], //la page ne s'affichera que si on à le token
    component: DetailDvdComponent
  },
  {
    path :'ajouter-dvd',
    canActivate: [AuthServiceService], //la page ne s'affichera que si on à le token
    component: AjouterDvdComponent
  },
  {
    path :'ajouter-client',
    canActivate: [AuthServiceService], //la page ne s'affichera que si on à le token
    component: GestionClientComponent
  },
  {
    path :'creer-vente',
    canActivate: [AuthServiceService], //la page ne s'affichera que si on à le token
    component: CreerVenteComponent
  },
  {
    path :'liste-client',
    canActivate: [AuthServiceService], //la page ne s'affichera que si on à le token
    component: ListeClientComponent
  }
  ,
  {
    path :'liste-vente',
    canActivate: [AuthServiceService], //la page ne s'affichera que si on à le token
    component: ListeVenteComponent
  },
  {
    path :'modifier-client/:id',
    canActivate: [AuthServiceService], //la page ne s'affichera que si on à le token
    component: ModifierClientComponent
  },
  {
    path :'modifier-dvd/:id',
    canActivate: [AuthServiceService], //la page ne s'affichera que si on à le token
    component: ModifierDvdComponent
  },
  {
    path :'creation-compte',
    component: CreationCompteComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
