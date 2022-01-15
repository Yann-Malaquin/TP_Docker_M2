import {Component, OnInit} from '@angular/core';
import {Person} from '../../../models/person/person.model';
import {AnnuaireService} from '../../../services/annuaire.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-annuaire',
  templateUrl: './annuaire.component.html',
  styleUrls: ['./annuaire.component.css']
})
export class AnnuaireComponent implements OnInit {

  public annuaire: Person[] = [];
  isSearch: boolean;
  isDisplayAll: boolean;
  isCompany: boolean;
  name: string | null;
  id: string | null;
  title: string | null;
  public error: boolean;
  public errorMessage: string | null;

  constructor(private annuaireService: AnnuaireService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {

    this.name = null;
    this.id = '';
    this.title = '';

    this.error = false;
    this.errorMessage = '';

    if (this.router.url.includes('recherche')) {
      this.isDisplayAll = false;
      this.isSearch = true;
      this.isCompany = false;
    } else if (this.router.url.includes('company')) {
      this.id = this.activatedRoute.snapshot.paramMap.get('id');
      this.isDisplayAll = false;
      this.isSearch = false;
      this.isCompany = true;
      this.title = 'Liste des personnes dans l\'entreprise '
    } else {
      this.isDisplayAll = true;
      this.isSearch = false;
      this.isCompany = false;
      this.title = 'Liste des personnes '
    }
  }

  ngOnInit(): void {

    this.activatedRoute.params.subscribe(routeParams => {
      this.name = routeParams['name'];
      this.getPersons();
    });

    if (this.id != null && this.isCompany) {
      this.getPersons();
    }
  }

  getPersons() {
    if (this.isDisplayAll) {
      this.annuaireService.getPersons()
        .subscribe(annuaireResponse => {
            this.annuaire = annuaireResponse;
            if (this.annuaire.length === 0) {
              this.error = true;
              this.errorMessage = 'Personne ne correspond aux critères. '
            }
          }
        );
    } else if (this.isSearch) {
      if (this.name != null) {
        this.annuaireService.getPersonsByName(this.name)
          .subscribe(annuaireResponse => {
              this.annuaire = annuaireResponse;
              if (this.annuaire.length === 0) {
                this.error = true;
                this.errorMessage = 'Personne ne correspond aux critères. '
              }
            },
            error1 => {
              if (error1.status == 404) {
                this.error = true;
                this.errorMessage = 'Recherche infructueuse.'
              }
            }
          );
      }
    } else if (this.isCompany) {
      if (this.id != null) {
        this.annuaireService.getCompany(+this.id).subscribe(annuaireResponse => {
          this.annuaire = annuaireResponse.personRestList;
          if (this.annuaire.length === 0) {
            this.error = true;
            this.errorMessage = 'Personne n\'a été trouvé. '
          }
        });
      }
    }
  }

  onDelete(id?: number) {
    this.annuaireService.deletePerson(id).subscribe(personResponse => {
      this.getPersons();
    });
  }

}
