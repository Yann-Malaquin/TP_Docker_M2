import {Component, OnInit} from '@angular/core';
import {AnnuaireService} from '../services/annuaire.service';
import {Person} from '../model/person.model';

@Component({
  selector: 'app-annuaire',
  templateUrl: './annuaire.component.html',
  styleUrls: ['./annuaire.component.css']
})
export class AnnuaireComponent implements OnInit {

  public annuaire: Person[];

  constructor(private annuaireService: AnnuaireService) {
  }

  ngOnInit(): void {

    this.annuaireService.getAnnuaire().subscribe(
      (annuaireResponse) => {
        console.log(annuaireResponse);
        this.annuaire = annuaireResponse;
      });
  }

}
