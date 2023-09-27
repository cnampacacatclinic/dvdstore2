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
    component: AdminHomeComponent
  },
  {
    path :'detail-dvd',
    component: DetailDvdComponent
  },
  {
    path :'modifier-dvd',
    component: ModifierDvdComponent
  },
  {
    path :'ajouter-dvd',
    component: AjouterDvdComponent
  },
  {
    path :'gestion-client',
    component: GestionClientComponent
  },
  {
    path :'creer-vente',
    component: CreerVenteComponent
  },
  {
    path :'liste-client',
    component: ListeClientComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
