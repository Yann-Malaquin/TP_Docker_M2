import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HomeComponent} from './components/home/home.component';
import {AnnuaireComponent} from './components/annuaire/person/annuaire.component';
import {AddPersonComponent} from './components/add-person/add-person.component';
import {AnnuaireService} from './services/annuaire.service';
import { AnnuaireCompanyComponent } from './components/annuaire/company/annuaire-company.component';
import { AddCompanyComponent } from './components/add-company/add-company.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AnnuaireComponent,
    AddPersonComponent,
    AnnuaireCompanyComponent,
    AddCompanyComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    AnnuaireService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
