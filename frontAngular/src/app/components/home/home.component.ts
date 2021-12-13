import { Component, OnInit } from '@angular/core';
import {Person} from "../../models/person.model";
import {AnnuaireService} from "../../services/annuaire.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public annuaire: Person[];

  constructor(private annuaireService: AnnuaireService) {
    this.annuaire  = [];
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
