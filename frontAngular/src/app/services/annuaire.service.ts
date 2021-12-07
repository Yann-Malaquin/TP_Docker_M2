import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Person} from "../models/person.model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AnnuaireService {

  constructor(private http: HttpClient) {
  }

  public getPersons(): Observable<Person[]> {
    return this.http.get<Person[]>(`${environment.url}/annuaireRest`);
  }

  public createPerson(person : Person): Observable<any>{
    return this.http.post(`${environment.url}/createPersonRest`, person);
  }

}
