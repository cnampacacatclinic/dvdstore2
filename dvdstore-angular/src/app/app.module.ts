import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
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
import { MdpOublieComponent } from './mdp-oublie/mdp-oublie.component';
import { ListePanierComponent } from './liste-panier/liste-panier.component';
import { FormulairePanierComponent } from './formulaire-panier/formulaire-panier.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    AdminHomeComponent,
    DetailDvdComponent,
    ModifierDvdComponent,
    AjouterDvdComponent,
    GestionClientComponent,
    CreerVenteComponent,
    ListeClientComponent,
    ListeVenteComponent,
    ModifierClientComponent,
    CreationCompteComponent,
    MdpOublieComponent,
    ListePanierComponent,
    FormulairePanierComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
