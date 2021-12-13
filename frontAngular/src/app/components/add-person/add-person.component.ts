import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AnnuaireService} from "../../services/annuaire.service";
import {Router} from "@angular/router";
import {Person} from "../../models/person.model";

@Component({
  selector: 'app-add-person',
  templateUrl: './add-person.component.html',
  styleUrls: ['./add-person.component.css']
})
export class AddPersonComponent implements OnInit {

  addPerson!: FormGroup;

  @Output() emitter = new EventEmitter<Person>();

  constructor(private formBuilder: FormBuilder,
              private annuaireService: AnnuaireService,
              private router: Router) {

    this.initForm();
  }

  ngOnInit(): void {
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

    this.annuaireService.createPerson(person)
      .subscribe(personResponse => {
        this.emitter.emit(personResponse);
        this.addPerson.reset();
      });

    this.router.navigate(['/']);
  }

}
