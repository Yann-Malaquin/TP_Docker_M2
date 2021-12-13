import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AnnuaireService} from "../../services/annuaire.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Person} from "../../models/person.model";

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

  @Output() emitter = new EventEmitter<Person>();

  constructor(private formBuilder: FormBuilder,
              private annuaireService: AnnuaireService,
              private router: Router,
              private activateRoute: ActivatedRoute) {

    this.initForm();
    this.id = '';

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
    if (this.id != null && this.isModifyingPerson) {
      this.getPerson(+this.id);
    }
  }

  initForm() {
    this.addPerson = this.formBuilder.group({
      inputLastName: '',
      inputSurname: '',
      inputPhone: '',
      inputCity: ''
    });
  }

  onSubmit(personForm: any): void {
    const person: Person = {
      name: personForm.inputLastName,
      surname: personForm.inputSurname,
      phone: personForm.inputPhone,
      city: personForm.inputCity,
    };

    if (this.isAddingPerson) {
      this.annuaireService.createPerson(person)
        .subscribe(personResponse => {
          this.emitter.emit(personResponse);
          this.addPerson.reset();
        });
    } else if (this.isModifyingPerson) {
      if (this.id != null) {
        this.annuaireService.updatePerson(person, +this.id).subscribe(personResponse => {
          this.emitter.emit(personResponse);
          this.addPerson.reset();
        });
      }
    }
    this.router.navigate(['/']);
  }

  getPerson(id?: number) {
    this.annuaireService.getPerson(id).subscribe(personResponse => {
      this.person = personResponse;
      this.addPerson.setValue({
        inputLastName: this.person?.name,
        inputSurname: this.person?.surname,
        inputPhone: this.person?.phone,
        inputCity: this.person?.city
      });
    });
  }

}
