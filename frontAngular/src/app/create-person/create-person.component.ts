import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AnnuaireService} from "../services/annuaire.service";
import {Router} from "@angular/router";
import {Person} from "../models/person.model";

@Component({
  selector: 'app-create-person',
  templateUrl: './create-person.component.html',
  styleUrls: ['./create-person.component.css']
})
export class CreatePersonComponent implements OnInit {

  createForm: FormGroup;
  @Output() createEvent = new EventEmitter<Person>();

  constructor(public formBuilder: FormBuilder, private annuaireService: AnnuaireService, private router: Router) {

    this.createForm = this.formBuilder.group({
      inputFirstName: '',
      inputLastName: '',
      inputPhone: '',
      inputCity: ''
    });

  }

  ngOnInit(): void {
  }

  onSubmit(personData: any): void {
    const person: Person = {
      name: personData.inputLastName,
      surname: personData.inputFirstName,
      phone: personData.inputPhone,
      city: personData.inputCity
    }

    this.annuaireService.createPerson(person).subscribe((personResponse) => {
      this.createEvent.emit(personResponse);
      this.createForm.reset();
      console.log(personResponse);
    });
    this.router.navigate(['/']);


  }

}
