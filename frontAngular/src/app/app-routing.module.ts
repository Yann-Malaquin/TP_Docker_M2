import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {AddPersonComponent} from './components/add-person/add-person.component';
import {AnnuaireComponent} from './components/annuaire/person/annuaire.component';
import {AnnuaireCompanyComponent} from './components/annuaire/company/annuaire-company.component';
import {AddCompanyComponent} from './components/add-company/add-company.component';

const routes: Routes = [
  {
    // URL redirigeant vers la page d'accueil
    path: '', component: HomeComponent
  },
  // URL redirigeant vers la liste des personnes
  {
    path: 'annuaire/personnes', component : AnnuaireComponent
  },
  // URL redirigeant vers la liste des entreprises
  {
    path: 'annuaire/entreprises', component : AnnuaireCompanyComponent
  },
  // URL redirigeant vers la liste des personnes
  {
    path: 'recherche/:name', component: AnnuaireComponent
  },
  {
    // URL redirigeant vers la création d'une personne
    path: 'creationPersonne', component: AddPersonComponent
  },
  {
    // URL redirigeant vers la création d'une entreprise
    path: 'creationEntreprise', component: AddCompanyComponent
  },
  // URL redirigeant vers la liste des personnes d'une entreprise donnée
  {
    path: 'company/:id', component: AnnuaireComponent
  },
  // URL redirigeant vers la modification d'une personne avec l'id correspondant
  {
    path: 'edit/:id', component: AddPersonComponent
  },
  // URL redirigeant vers la modification d'une entreprise avec l'id correspondant
  {
    path: 'editCompany/:id', component: AddCompanyComponent
  },
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
