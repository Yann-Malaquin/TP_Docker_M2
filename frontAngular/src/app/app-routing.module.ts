import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AnnuaireComponent} from './annuaire/annuaire.component';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {
    path: '', component: AnnuaireComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
