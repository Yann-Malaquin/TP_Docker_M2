import {Component, OnInit} from '@angular/core';
import {Person} from "../../models/person.model";
import {AnnuaireService} from "../../services/annuaire.service";

@Component({
  selector: 'app-annuaire',
  templateUrl: './annuaire.component.html',
  styleUrls: ['./annuaire.component.css']
})
export class AnnuaireComponent implements OnInit {

  public annuaire: Person[] = [];

  constructor(private annuaireService: AnnuaireService) {

  }

  ngOnInit(): void {
    this.getPersons();
  }

  getPersons() {
    this.annuaireService.getPersons()
      .subscribe(annuaireResponse => {
          this.annuaire = annuaireResponse;
        }
      );
  }

}
