import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AnnuaireComponent} from "./annuaire/annuaire.component";

const routes: Routes = [
  {
    path: '', component: AnnuaireComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
