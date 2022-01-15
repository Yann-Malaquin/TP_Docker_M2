import {Component, OnInit} from '@angular/core';
import {AnnuaireService} from '../../../services/annuaire.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Company} from '../../../models/company/company.model';

@Component({
  selector: 'app-annuaire-company',
  templateUrl: './annuaire-company.component.html',
  styleUrls: ['./annuaire-company.component.css']
})
export class AnnuaireCompanyComponent implements OnInit {

  public annuaire: Company[] = [];
  public error: boolean;
  public errorMessage: string | null;

  constructor(private annuaireService: AnnuaireService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.error = false;
    this.errorMessage = '';
  }

  ngOnInit(): void {
    this.getCompanies();
  }

  getCompanies() {
    this.annuaireService.getCompanies()
      .subscribe(annuaireResponse => {
          this.annuaire = annuaireResponse;

          if (this.annuaire.length === 0) {
            this.error = true;
            this.errorMessage = 'Aucune entreprise ne correspond aux critères. '
          }
        }
      );
  }

  onDelete(id?: number) {
    this.annuaireService.deleteCompany(id).subscribe(companyResponse => {
      this.getCompanies();
    });
  }
}
