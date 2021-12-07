import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AnnuaireComponent} from "./annuaire/annuaire.component";
import {CreatePersonComponent} from "./create-person/create-person.component";

const routes: Routes = [
  {
    path: '', component: AnnuaireComponent
  },
  {
    path: 'ajout', component: CreatePersonComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
