import {Component, OnInit} from '@angular/core';
import {Person} from "../../models/person.model";
import {AnnuaireService} from "../../services/annuaire.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-annuaire',
  templateUrl: './annuaire.component.html',
  styleUrls: ['./annuaire.component.css']
})
export class AnnuaireComponent implements OnInit {

  public annuaire: Person[] = [];
  isSearch: boolean;
  isDisplayAll: boolean;
  name: string | null;

  constructor(private annuaireService: AnnuaireService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {

    this.name = null;

    if (this.router.url.includes('recherche')) {
      this.isDisplayAll = false;
      this.isSearch = true;
    } else {
      this.isSearch = false;
      this.isDisplayAll = true;
    }
  }

  ngOnInit(): void {

    this.activatedRoute.params.subscribe(routeParams => {
      this.name = routeParams['name'];
      this.getPersons();
    });
  }

  getPersons() {
    if (this.isDisplayAll) {
      this.annuaireService.getPersons()
        .subscribe(annuaireResponse => {
            this.annuaire = annuaireResponse;
          }
        );
    } else if (this.isSearch) {
      if (this.name != null) {
        this.annuaireService.getPersonsByName(this.name)
          .subscribe(annuaireResponse => {
              this.annuaire = annuaireResponse;
            }
          );
      }
    }
  }

  onDelete(id?: number) {
    this.annuaireService.deletePerson(id).subscribe(personResponse => {
      this.getPersons();
    });
  }

}
