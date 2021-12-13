import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {AddPersonComponent} from "./components/add-person/add-person.component";

const routes: Routes = [
  {
    // URL redirigeant vers la page d'accueil
    path: '', component: HomeComponent
  },
  {
    // URL redirigeant vers la création d'une personne
    path: 'creationPersonne', component: AddPersonComponent
  },
  // URL redirigeant vers la modification d'une personne avec l'id correspondant
  {
    path: 'edit/:id', component: AddPersonComponent
  }
  ,
  {
    // Redirection vers la page d'accueil si l'URL saisie est inexistante
    path: '**', redirectTo: ''
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
