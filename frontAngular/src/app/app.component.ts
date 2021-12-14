import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AnnuaireService} from "./services/annuaire.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'frontAngular';

  searchForm!: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private annuaireService: AnnuaireService,
              private router: Router
  ) {

    this.initForm();
  }

  ngOnInit() {
  }

  initForm() {
    this.searchForm = this.formBuilder.group({
      inputSearch: ''
    })
  }

  onSubmit(search: any): void {
    this.router.navigate(['recherche/', search.inputSearch]);
  }

}
