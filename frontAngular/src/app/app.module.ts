import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HomeComponent} from './components/home/home.component';
import {AnnuaireComponent} from './components/annuaire/annuaire.component';
import {AddPersonComponent} from './components/add-person/add-person.component';
import {AnnuaireService} from "./services/annuaire.service";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AnnuaireComponent,
    AddPersonComponent,
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
