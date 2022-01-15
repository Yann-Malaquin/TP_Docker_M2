import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Company} from '../../models/company/company.model';
import {AnnuaireService} from '../../services/annuaire.service';

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {

  addCompany!: FormGroup;
  company?: Company;
  isAddingCompany: boolean;
  isModifyingCompany: boolean;
  id: string | null;
  public error: boolean;
  public errorMessage: string | null;

  @Output() emitter = new EventEmitter<Company>();

  constructor(private formBuilder: FormBuilder,
              private annuaireService: AnnuaireService,
              private router: Router,
              private activateRoute: ActivatedRoute) {

    this.initForm();
    this.id = '';
    this.error = false;
    this.errorMessage = '';

    if (this.router.url.includes('editCompany')) {
      this.id = this.activateRoute.snapshot.paramMap.get('id');
      this.isAddingCompany = false;
      this.isModifyingCompany = true;
    } else {
      this.isAddingCompany = true;
      this.isModifyingCompany = false;
    }

  }

  ngOnInit(): void {
    if (this.id != null && this.isModifyingCompany) {
      this.getCompany(+this.id);
    }
  }

  initForm() {
    this.addCompany = this.formBuilder.group({
      inputName: '',
      inputPhone: '',
      inputAddress: '',
      inputCity: '',
      inputCountry: ''
    });
  }

  onSubmit(companyForm: any): void {
    const company: Company = {
      name: companyForm.inputName,
      phone: companyForm.inputPhone,
      address: companyForm.inputAddress,
      city: companyForm.inputCity,
      country: companyForm.inputCountry,
    };

    if (this.isAddingCompany) {
      this.annuaireService.createCompany(company)
        .subscribe(companyResponse => {
          this.emitter.emit(companyResponse);
          this.addCompany.reset();
          this.router.navigate(['/annuaire/entreprises']);
        }, error1 => {
          if (error1.status == 409) {
            this.error = true;
            this.errorMessage = 'Entreprise déjà existante, choisir un autre numéro de téléphone !'
          }
        });
    } else if (this.isModifyingCompany) {
      if (this.id != null) {
        this.annuaireService.updateCompany(company, +this.id).subscribe(companyResponse => {
          this.emitter.emit(companyResponse);
          this.addCompany.reset();
          this.router.navigate(['/annuaire/entreprises']);
        });
      }
    }
  }

  getCompany(id?: number) {
    this.annuaireService.getCompany(id).subscribe(companyResponse => {
      this.company = companyResponse;
      this.addCompany.setValue({
        inputName: this.company?.name,
        inputPhone: this.company?.phone,
        inputCity: this.company?.city,
        inputAddress: this.company?.address,
        inputCountry: this.company?.country,
      });
    });
  }

}
