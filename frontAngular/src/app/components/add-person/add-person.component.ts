import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {AnnuaireService} from '../../services/annuaire.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Person} from '../../models/person/person.model';
import {Company} from '../../models/company/company.model';

@Component({
  selector: 'app-add-person',
  templateUrl: './add-person.component.html',
  styleUrls: ['./add-person.component.css']
})
export class AddPersonComponent implements OnInit {

  addPerson!: FormGroup;
  isAddingPerson: boolean;
  isModifyingPerson: boolean;
  person?: Person;
  id: string | null;
  public annuaire: Company[] = [];
  public error: boolean;
  public errorMessage: string | null;

  @Output() emitter = new EventEmitter<Person>();

  constructor(private formBuilder: FormBuilder,
              private annuaireService: AnnuaireService,
              private router: Router,
              private activateRoute: ActivatedRoute) {

    this.initForm();
    this.id = '';
    this.error = false;
    this.errorMessage = '';

    if (this.router.url.includes('edit')) {
      this.id = this.activateRoute.snapshot.paramMap.get('id');
      this.isAddingPerson = false;
      this.isModifyingPerson = true;
    } else {
      this.isAddingPerson = true;
      this.isModifyingPerson = false;
    }
  }

  ngOnInit(): void {

    this.getCompanies();

    if (this.id != null && this.isModifyingPerson) {
      this.getPerson(+this.id);
    }
  }

  initForm() {
    this.addPerson = this.formBuilder.group({
      inputLastName: '',
      inputSurname: '',
      inputPhone: '',
      inputCity: '',
      inputCompany: '',
    });
  }

  onSubmit(personForm: any): void {
    const person: Person = {
      name: personForm.inputLastName,
      surname: personForm.inputSurname,
      phone: personForm.inputPhone,
      city: personForm.inputCity,
      company_id: personForm.inputCompany
    };

    if (this.isAddingPerson) {
      this.annuaireService.createPerson(person)
        .subscribe(personResponse => {
          this.emitter.emit(personResponse);
          this.addPerson.reset();
          this.router.navigate(['/annuaire/personnes']);
        }, error1 => {
          if (error1.status == 409) {
            this.error = true;
            this.errorMessage = 'Personne déjà existante, choisir un autre numéro de téléphone !'
          }
        });
    } else if (this.isModifyingPerson) {
      if (this.id != null) {
        this.annuaireService.updatePerson(person, +this.id)
          .subscribe(personResponse => {
            this.emitter.emit(personResponse);
            this.addPerson.reset();
            this.router.navigate(['/annuaire/personnes']);
          });
      }
    }
  }

  getPerson(id?: number) {
    this.annuaireService.getPerson(id).subscribe(personResponse => {
      this.person = personResponse;
      this.addPerson.setValue({
        inputLastName: this.person?.name,
        inputSurname: this.person?.surname,
        inputPhone: this.person?.phone,
        inputCity: this.person?.city,
        inputCompany: '',
      });
    });
  }

  getCompanies() {
    this.annuaireService.getCompanies()
      .subscribe(annuaireResponse => {
          this.annuaire = annuaireResponse;
        }
      );
  }

}
